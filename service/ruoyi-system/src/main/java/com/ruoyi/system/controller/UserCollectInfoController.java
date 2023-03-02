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
import com.ruoyi.system.domain.UserCollectInfo;
import com.ruoyi.system.service.IUserCollectInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户访问记录Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Controller
@RequestMapping("/system/collection")
public class UserCollectInfoController extends BaseController
{
    private String prefix = "system/collection";

    @Autowired
    private IUserCollectInfoService userCollectInfoService;

    @RequiresPermissions("system:collection:view")
    @GetMapping()
    public String collection()
    {
        return prefix + "/collection";
    }

    /**
     * 查询用户访问记录列表
     */
    @RequiresPermissions("system:collection:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserCollectInfo userCollectInfo)
    {
        startPage();
        List<UserCollectInfo> list = userCollectInfoService.selectUserCollectInfoList(userCollectInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户访问记录列表
     */
    @RequiresPermissions("system:collection:export")
    @Log(title = "用户访问记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserCollectInfo userCollectInfo)
    {
        List<UserCollectInfo> list = userCollectInfoService.selectUserCollectInfoList(userCollectInfo);
        ExcelUtil<UserCollectInfo> util = new ExcelUtil<UserCollectInfo>(UserCollectInfo.class);
        return util.exportExcel(list, "collection");
    }

    /**
     * 新增用户访问记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户访问记录
     */
    @RequiresPermissions("system:collection:add")
    @Log(title = "用户访问记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserCollectInfo userCollectInfo)
    {
        return toAjax(userCollectInfoService.insertUserCollectInfo(userCollectInfo));
    }

    /**
     * 修改用户访问记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UserCollectInfo userCollectInfo = userCollectInfoService.selectUserCollectInfoById(id);
        mmap.put("userCollectInfo", userCollectInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户访问记录
     */
    @RequiresPermissions("system:collection:edit")
    @Log(title = "用户访问记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserCollectInfo userCollectInfo)
    {
        return toAjax(userCollectInfoService.updateUserCollectInfo(userCollectInfo));
    }

    /**
     * 删除用户访问记录
     */
    @RequiresPermissions("system:collection:remove")
    @Log(title = "用户访问记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userCollectInfoService.deleteUserCollectInfoByIds(ids));
    }
}
