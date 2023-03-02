package com.ruoyi.web.api;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.UserCollectInfo;
import com.ruoyi.system.service.ICommentInfoService;
import com.ruoyi.system.service.IContentInfoService;
import com.ruoyi.system.service.IUserCollectInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**

 * @date 2021/4/6

 */
@Api("用户收藏管理")
@RequestMapping("/api/v1/collect")
@RestController
@CrossOrigin
public class UserCollectApiController {

    @Autowired
    private IUserCollectInfoService service;
    @Autowired
    private IContentInfoService contentInfoService;
    @Autowired
    private ICommentInfoService commentInfoService;

    private AjaxResult changeCollect( Long commentId,Integer type) {
        Long userId = ShiroUtils.getUserId();
        UserCollectInfo param = new UserCollectInfo();
        param.setcId(commentId);
        param.setType(type);
        if (userId == null) {
            return AjaxResult.error("用户未登录");
        }
        param.setUserId(userId);
        int changeCount = 0;
        param = service.selectUserCollectionByParam(param);
        if (param != null) {
            changeCount = -1;
            service.deleteUserCollectInfoById(param.getId());
        } else {
            changeCount = 1;
            UserCollectInfo insert = new UserCollectInfo();
            insert.setUserId(userId);
            insert.setType(type);
            insert.setcId(commentId);
            service.insertUserCollectInfo(insert);
        }
        switch (type) {
            case 1:
            case 2:
                contentInfoService.addLikeCount(changeCount, commentId);
                break;
            case 3:
            case 4:
                commentInfoService.addLikeCount(changeCount, commentId);
            default:
                break;

        }
        return AjaxResult.success();
    }

    /**
     * 点赞评论
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/commentLike", method = RequestMethod.POST)
    @ApiOperation("点赞评论")
    public AjaxResult commentLike(@RequestParam @ApiParam Long commentId){
        return changeCollect(commentId, 4);
    }

    @ApiOperation("点赞文章")
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public AjaxResult like(@RequestParam Long articleId){
        return changeCollect(articleId, 2);
    }

    @ApiOperation("收藏文章")
    @RequestMapping(value = "/favorite", method = RequestMethod.POST)
    public AjaxResult favorite(@RequestParam Long articleId){
        return changeCollect(articleId, 1);
    }

}
