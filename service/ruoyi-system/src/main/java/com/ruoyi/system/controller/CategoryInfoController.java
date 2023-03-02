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
import com.ruoyi.system.domain.CategoryInfo;
import com.ruoyi.system.service.ICategoryInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分类管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Controller
@RequestMapping("/system/category")
public class CategoryInfoController extends BaseController
{
    private String prefix = "system/category";

    @Autowired
    private ICategoryInfoService categoryInfoService;

    @RequiresPermissions("system:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询分类管理列表
     */
    @RequiresPermissions("system:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CategoryInfo categoryInfo)
    {
        startPage();
        List<CategoryInfo> list = categoryInfoService.selectCategoryInfoList(categoryInfo);
        return getDataTable(list);
    }

    /**
     * 导出分类管理列表
     */
    @RequiresPermissions("system:category:export")
    @Log(title = "分类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CategoryInfo categoryInfo)
    {
        List<CategoryInfo> list = categoryInfoService.selectCategoryInfoList(categoryInfo);
        ExcelUtil<CategoryInfo> util = new ExcelUtil<CategoryInfo>(CategoryInfo.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增分类管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分类管理
     */
    @RequiresPermissions("system:category:add")
    @Log(title = "分类管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CategoryInfo categoryInfo)
    {
        return toAjax(categoryInfoService.insertCategoryInfo(categoryInfo));
    }

    /**
     * 修改分类管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CategoryInfo categoryInfo = categoryInfoService.selectCategoryInfoById(id);
        mmap.put("categoryInfo", categoryInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存分类管理
     */
    @RequiresPermissions("system:category:edit")
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CategoryInfo categoryInfo)
    {
        return toAjax(categoryInfoService.updateCategoryInfo(categoryInfo));
    }

    /**
     * 删除分类管理
     */
    @RequiresPermissions("system:category:remove")
    @Log(title = "分类管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(categoryInfoService.deleteCategoryInfoByIds(ids));
    }
}
