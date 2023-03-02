package com.ruoyi.system.controller;

import java.util.Date;
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
import com.ruoyi.system.domain.ContentInfo;
import com.ruoyi.system.service.IContentInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻管理Controller
 *
 * @author ruoyi
 * @date 2021-04-05
 */
@Controller
@RequestMapping("/system/content")
public class ContentInfoController extends BaseController {
    private String prefix = "system/content";

    @Autowired
    private IContentInfoService contentInfoService;

    @RequiresPermissions("system:content:view")
    @GetMapping()
    public String content() {
        return prefix + "/content";
    }

    /**
     * 查询新闻管理列表
     */
    @RequiresPermissions("system:content:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ContentInfo contentInfo) {
        startPage();
        List<ContentInfo> list = contentInfoService.selectContentInfoList(contentInfo);
        return getDataTable(list);
    }

    /**
     * 导出新闻管理列表
     */
    @RequiresPermissions("system:content:export")
    @Log(title = "新闻管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ContentInfo contentInfo) {
        List<ContentInfo> list = contentInfoService.selectContentInfoList(contentInfo);
        ExcelUtil<ContentInfo> util = new ExcelUtil<ContentInfo>(ContentInfo.class);
        return util.exportExcel(list, "content");
    }

    /**
     * 新增新闻管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存新闻管理
     */
    @RequiresPermissions("system:content:add")
    @Log(title = "新闻管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ContentInfo contentInfo) {
        return toAjax(contentInfoService.insertContentInfo(contentInfo));
    }

    /**
     * 修改新闻管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ContentInfo contentInfo = contentInfoService.selectContentInfoById(id);
        mmap.put("contentInfo", contentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻管理
     */
    @RequiresPermissions("system:content:edit")
    @Log(title = "新闻管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ContentInfo contentInfo) {
        return toAjax(contentInfoService.updateContentInfo(contentInfo));
    }

    @ResponseBody
    @RequiresPermissions("system:content:edit")
    @Log(title = "新闻管理", businessType = BusinessType.UPDATE)
    @PostMapping("/process")
    public AjaxResult process(Long id) {
        ContentInfo content = contentInfoService.selectContentInfoById(id);
        if (content == null) {
            return error();
        }
        content.setAfterProcess(1);
        content.setEnable(0);
        content.setProcessingTime(new Date());
        int result = contentInfoService.updateContentInfo(content);
        return success();
    }

    /**
     * 删除新闻管理
     */
    @RequiresPermissions("system:content:remove")
    @Log(title = "新闻管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(contentInfoService.deleteContentInfoByIds(ids));
    }
}
