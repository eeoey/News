package com.ruoyi.task;

import cn.hutool.core.date.DateTime;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.CategoryInfo;
import com.ruoyi.system.domain.ContentInfo;
import com.ruoyi.system.service.ICategoryInfoService;
import com.ruoyi.system.service.IContentInfoService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.print.Doc;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component("autoCheck")
public class AutoCheckTask {
    @Autowired
    private ICategoryInfoService service;

    @Autowired
    private IContentInfoService contentInfoService;

    /**
     * @PostConstruct 打开注释代表启动项目时执行taskParam方法，从网易新闻爬取最新的新闻
     */
//    @PostConstruct
    public void taskParam() {
        CategoryInfo param = new CategoryInfo();
        param.setQuery(true);
        param.setEnable(1);
        List<CategoryInfo> list = service.selectCategoryInfoList(param);
        for (CategoryInfo c : list) {
            int i = 0;
            Document index = Parser.parse(HttpUtil.get(c.getQueryUrl()), c.getQueryUrl());
            Elements indexArr = index.select(".data_row");
            boolean isData_row = true;
            if (indexArr.size() == 0) {
                indexArr = index.select(".hidden div");
                isData_row = false;
            }
            if (indexArr != null) {
                for (Element obj : indexArr) {
                    try {
                        ContentInfo cParam = new ContentInfo();
                        System.out.println(obj.selectFirst("a"));
                        System.out.println(obj.selectFirst("a").absUrl("href"));
                        cParam.setSourceUrl(obj.selectFirst("a").absUrl("href"));
                        if (!contentInfoService.selectContentInfoList(cParam).isEmpty()) {
                            System.out.println("新闻已经爬过了，跳过这个新闻");
                            continue;
                        }
                        if (isData_row) {
                            cParam.setTitle(obj.select(".news_title").text());
                        }else{
                            cParam.setTitle(obj.select("a").text());
                        }
                        cParam.setRead(0);
                        cParam.setCategoryId(c.getId());
                        Element img = obj.select("img").first();
                        if(img != null) {
                            cParam.setPhotoUrl(img.absUrl("src").split("\\?")[0]);
                        }
                        cParam.setSource("网易新闻");
                        cParam.setEnable(0);
                        cParam.setAfterProcess(1);
                        cParam.setProcessingTime(DateTime.now());
                        HttpRequest req = HttpUtil.createGet(cParam.getSourceUrl());
                        Document doc = Parser.parse(req.execute().body(), cParam.getSourceUrl());
                        Elements body = doc.select(".post_body");
                        Thread.sleep(1 * 1000);
                        cParam.setContent(body.html());
                        cParam.setDes(body.text());
                        if (StringUtils.isEmpty(cParam.getPhotoUrl())) {
                            img = body.select("img").first();
                            if (img != null) {
                                cParam.setPhotoUrl(img.absUrl("src"));
                            }
                        }
                        int row = contentInfoService.insertContentInfo(cParam);
                        i = i + row;
                        if (i == 20) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(obj.text());
                        e.printStackTrace();
                    }

                }
            }

        }
    }
}
