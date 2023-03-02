package com.ruoyi.web.api;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.domain.CategoryInfo;
import com.ruoyi.system.domain.ContentInfo;
import com.ruoyi.system.service.ICategoryInfoService;
import com.ruoyi.system.service.IContentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**

 * @date 2021/4/5

 */
@RestController
@Api("新闻分类管理")
@RequestMapping("/api/v1/category")
@CrossOrigin
public class CategoryApiController {
    @Autowired
    private ICategoryInfoService service;

    @Autowired
    private IContentInfoService contentInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation("列表")
    public AjaxResult list(){
        CategoryInfo param = new CategoryInfo();
        param.setEnable(1);
        List<CategoryInfo> list = service.selectCategoryInfoList(param);

        return AjaxResult.success(list);
    }

    @ApiOperation("查询腾讯新闻")
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public AjaxResult query(){
        CategoryInfo param = new CategoryInfo();
        param.setQuery(true);
        param.setEnable(1);
        List<CategoryInfo> list = service.selectCategoryInfoList(param);
        for(CategoryInfo c : list){
            JSONObject result = JSONUtil.parseObj( HttpUtil.get(c.getQueryUrl()));
            JSONArray array = result.getJSONObject("data").getJSONArray("list");
            for(JSONObject obj : array.jsonIter()){
                ContentInfo cParam = new ContentInfo();
                cParam.setSourceUrl(obj.getStr("url"));
                if(!contentInfoService.selectContentInfoList(cParam).isEmpty()){
                    continue;
                }
                cParam.setTitle(obj.getStr("title"));
                cParam.setRead(0);
                cParam.setCategoryId(c.getId());
                cParam.setPhotoUrl(obj.getStr("thumb_nail"));
                cParam.setSource("腾讯新闻");
                try {
                    Document doc = Jsoup.connect(cParam.getSourceUrl()).get();
                    cParam.setContent(doc.select(".content-article").html());
                    contentInfoService.insertContentInfo(cParam);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return AjaxResult.success();
    }
}
