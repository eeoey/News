package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * 普通用户管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Repository
public interface UserInfoMapper 
{
    /**
     * 查询普通用户管理
     * 
     * @param id 普通用户管理ID
     * @return 普通用户管理
     */
    public UserInfo selectUserInfoById(Long id);

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

    /**
     * 删除普通用户管理
     * 
     * @param id 普通用户管理ID
     * @return 结果
     */
    public int deleteUserInfoById(Long id);

    /**
     * 批量删除普通用户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserInfoByIds(String[] ids);
}
