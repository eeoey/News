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
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.IUserInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 普通用户管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Controller
@RequestMapping("/system/commonUser")
public class UserInfoController extends BaseController
{
    private String prefix = "system/commonUser";

    @Autowired
    private IUserInfoService userInfoService;

    @RequiresPermissions("system:commonUser:view")
    @GetMapping()
    public String commonUser()
    {
        return prefix + "/commonUser";
    }

    /**
     * 查询普通用户管理列表
     */
    @RequiresPermissions("system:commonUser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserInfo userInfo)
    {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return getDataTable(list);
    }

    /**
     * 导出普通用户管理列表
     */
    @RequiresPermissions("system:commonUser:export")
    @Log(title = "普通用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        return util.exportExcel(list, "commonUser");
    }

    /**
     * 新增普通用户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存普通用户管理
     */
    @RequiresPermissions("system:commonUser:add")
    @Log(title = "普通用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserInfo userInfo)
    {
        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    /**
     * 修改普通用户管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UserInfo userInfo = userInfoService.selectUserInfoById(id);
        mmap.put("userInfo", userInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存普通用户管理
     */
    @RequiresPermissions("system:commonUser:edit")
    @Log(title = "普通用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserInfo userInfo)
    {
        return toAjax(userInfoService.updateUserInfo(userInfo));
    }

    /**
     * 删除普通用户管理
     */
    @RequiresPermissions("system:commonUser:remove")
    @Log(title = "普通用户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userInfoService.deleteUserInfoByIds(ids));
    }
}
