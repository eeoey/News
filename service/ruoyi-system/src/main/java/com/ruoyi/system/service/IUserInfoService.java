package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.UserInfo;

/**
 * 普通用户管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface IUserInfoService 
{
    /**
     * 查询普通用户管理
     * 
     * @param id 普通用户管理ID
     * @return 普通用户管理
     */
    public UserInfo selectUserInfoById(Long id);

    /**
     * 使用Shiro登录
     * @param user
     * @param password
     * @return
     */
    SysUser shiroLogin(String user, String password);

    void register(UserInfo user);
    /**
     * 查询普通用户管理列表
     * 
     * @param userInfo 普通用户管理
     * @return 普通用户管理集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增普通用户管理
     * 
     * @param userInfo 普通用户管理
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改普通用户管理
     * 
     * @param userInfo 普通用户管理
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    public void changePassword(Long userId, String oldPwd, String newPwd);
    /**
     * 批量删除普通用户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserInfoByIds(String ids);

    /**
     * 删除普通用户管理信息
     * 
     * @param id 普通用户管理ID
     * @return 结果
     */
    public int deleteUserInfoById(Long id);
}
