package com.ruoyi.web.api;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.CommentInfo;
import com.ruoyi.system.domain.ContentInfo;
import com.ruoyi.system.service.ICommentInfoService;
import com.ruoyi.system.service.IContentInfoService;
import com.ruoyi.system.service.IUserCollectInfoService;
import com.ruoyi.system.service.impl.UserCollectInfoServiceImpl;
import com.ruoyi.system.vo.CommentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**

 * @date 2021/4/5

 */
@RestController
@CrossOrigin
@Api("文章管理")
@RequestMapping("/api/v1/content")
public class ContentApiController extends BaseController {
    @Autowired
    public IContentInfoService service;

    @Autowired
    private ICommentInfoService commentInfoService;

    @Autowired
    private IUserCollectInfoService collectInfoService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation("获取首页新闻")
    public AjaxResult index(@RequestBody @ApiParam ContentInfo param) {
        startPage();
        param.setAfterProcess(1);
        param.setEnable(0);
        List<ContentInfo> list = service.selectContentInfoList(param);
        AjaxResult result = AjaxResult.success(getDataTable(list));
        param.setSlider(1);
        List<ContentInfo> slider = service.selectContentInfoList(param).stream().limit(10).collect(Collectors.toList());
        result.put("slider", slider);
        return result;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation("查询信息")
    public AjaxResult search(String keyword){
        startPage();
        List<ContentInfo> list = service.searchList(keyword);
        return AjaxResult.success(getDataTable(list));
    }

    @ApiOperation("详情")
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    public AjaxResult detail(@RequestParam @ApiParam Long id, @RequestParam("page_size") @ApiParam Integer pageSize) {
        ContentInfo detail = service.selectContentInfoById(id);
        PageHelper.startPage(1,pageSize);
        List<CommentVO> comments = commentInfoService.selectCommentVoByArticleId(id, ShiroUtils.getUserId());
        AjaxResult result = AjaxResult.success(detail);
        ContentInfo update = new ContentInfo();
        update.setId(id);
        update.setRead(detail.getRead()+1);
        service.updateContentInfo(update);
        result.put("comment", getDataTable(comments));
        Boolean favorite = collectInfoService.isFavorite(ShiroUtils.getUserId(), detail.getId());
        Boolean isLike = collectInfoService.isLike(ShiroUtils.getUserId(), detail.getId());
        result.put("favorite", favorite);
        result.put("like", isLike);
        return result;
    }

    @ApiOperation("获取推荐新闻")
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public AjaxResult recommend(Long userId){
        List<ContentInfo> list = service.recommend(userId);
        return AjaxResult.success(list);
    }


    @ApiOperation("个人发布新闻")
    @RequestMapping(value = "prepublish", method = RequestMethod.POST)
    public AjaxResult prePublish(@RequestBody @ApiParam ContentInfo param){
        param.setAfterProcess(0);
        param.setEnable(1);
        param.setUserId(ShiroUtils.getUserId());
        service.insertContentInfo(param);
        return success();
    }

}
