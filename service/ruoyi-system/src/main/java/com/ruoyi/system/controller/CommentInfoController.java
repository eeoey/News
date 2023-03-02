package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CommentInfo;
import com.ruoyi.system.service.ICommentInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Controller
@RequestMapping("/system/comment")
public class CommentInfoController extends BaseController
{
    private String prefix = "system/comment";

    @Autowired
    private ICommentInfoService commentInfoService;

    @RequiresPermissions("system:comment:view")
    @GetMapping()
    public String comment()
    {
        return prefix + "/comment";
    }

    /**
     * 查询评论管理列表
     */
    @RequiresPermissions("system:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CommentInfo commentInfo)
    {
        startPage();
        List<CommentInfo> list = commentInfoService.selectCommentInfoList(commentInfo);
        return getDataTable(list);
    }

    /**
     * 导出评论管理列表
     */
    @RequiresPermissions("system:comment:export")
    @Log(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CommentInfo commentInfo)
    {
        List<CommentInfo> list = commentInfoService.selectCommentInfoList(commentInfo);
        ExcelUtil<CommentInfo> util = new ExcelUtil<CommentInfo>(CommentInfo.class);
        return util.exportExcel(list, "comment");
    }

    /**
     * 新增评论管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论管理
     */
    @RequiresPermissions("system:comment:add")
    @Log(title = "评论管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CommentInfo commentInfo)
    {
        return toAjax(commentInfoService.insertCommentInfo(commentInfo));
    }

    /**
     * 修改评论管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CommentInfo commentInfo = commentInfoService.selectCommentInfoById(id);
        mmap.put("commentInfo", commentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论管理
     */
    @RequiresPermissions("system:comment:edit")
    @Log(title = "评论管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommentInfo commentInfo)
    {
        return toAjax(commentInfoService.updateCommentInfo(commentInfo));
    }

    /**
     * 删除评论管理
     */
    @RequiresPermissions("system:comment:remove")
    @Log(title = "评论管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(commentInfoService.deleteCommentInfoByIds(ids));
    }
}
