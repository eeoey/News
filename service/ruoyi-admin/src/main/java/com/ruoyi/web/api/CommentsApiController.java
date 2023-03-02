package com.ruoyi.web.api;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.CommentInfo;
import com.ruoyi.system.domain.ContentInfo;
import com.ruoyi.system.service.ICommentInfoService;
import com.ruoyi.system.service.IContentInfoService;
import com.ruoyi.system.vo.CommentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**

 * @date 2021/4/6

 */
@Api("评论、回复管理")
@RequestMapping("/api/v1/comments")
@RestController
@CrossOrigin
public class CommentsApiController extends BaseController {

    @Autowired
    private ICommentInfoService service;

    @Autowired
    private IContentInfoService contentInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation("文章的评论列表")
    public AjaxResult list(@RequestParam @ApiParam Long articleId, @RequestParam @ApiParam Integer pageIndex, @RequestParam @ApiParam  Integer pageSize){

        System.out.println("asdasda");
        PageHelper.startPage(pageIndex, pageSize);
        List<CommentVO> list = service.selectCommentVoByArticleId(articleId, ShiroUtils.getUserId());
        return AjaxResult.success(getDataTable(list));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ApiOperation("评论详情")
    public AjaxResult detail(@RequestParam @ApiParam Long id, @RequestParam @ApiParam Integer pageIndex, @RequestParam @ApiParam Integer pageSize){

        CommentVO detail = service.selectCommentVoByIdAndUserId(id, ShiroUtils.getUserId());

        PageHelper.startPage(pageIndex, pageSize);

        List<CommentVO> replies = service.selectDetailVoByIdAndUserId(id, ShiroUtils.getUserId());

        AjaxResult result = AjaxResult.success(detail);
        result.put("reply", getDataTable(replies));

        return result;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加评论")
    public AjaxResult add(@RequestBody @ApiParam CommentInfo param){
        ContentInfo content = contentInfoService.selectContentInfoById(param.getcId());
        if(content == null){
            return AjaxResult.error("文章不存在");
        }
        content.setCommentCount(content.getCommentCount() + 1);
        contentInfoService.updateContentInfo(content);
        param.setUserId(ShiroUtils.getUserId());
        param.setLikeCount(0);
        param.setReplyCount(0);

        service.insertCommentInfo(param);

        return AjaxResult.success();
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ApiOperation("回复")
    public AjaxResult addReply(@RequestBody @ApiParam CommentInfo param){
        CommentInfo comment = service.selectCommentInfoById(param.getPid());
        comment.setReplyCount(comment.getReplyCount()+1);
        service.updateCommentInfo(comment);
        param.setReplyCount(0);
        param.setLikeCount(0);
        param.setUserId(ShiroUtils.getUserId());
        service.insertCommentInfo(param);

        List<CommentVO> list = service.selectDetailVoByIdAndUserId(param.getPid(), param.getUserId());
        return AjaxResult.success(list);
    }
}
