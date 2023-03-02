package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UserCollectInfo;

/**
 * 用户访问记录Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface IUserCollectInfoService 
{
    /**
     * 查询用户访问记录
     * 
     * @param id 用户访问记录ID
     * @return 用户访问记录
     */
    public UserCollectInfo selectUserCollectInfoById(Long id);

    /**
     * 查询用户访问记录列表
     * 
     * @param userCollectInfo 用户访问记录
     * @return 用户访问记录集合
     */
    public List<UserCollectInfo> selectUserCollectInfoList(UserCollectInfo userCollectInfo);

    /**
     * 通过条件查询 对象
     * @param param 条件
     * @return 结果
     */
    UserCollectInfo selectUserCollectionByParam(UserCollectInfo param);
    /**
     * 新增用户访问记录
     * 
     * @param userCollectInfo 用户访问记录
     * @return 结果
     */
    public int insertUserCollectInfo(UserCollectInfo userCollectInfo);

    /**
     * 修改用户访问记录
     * 
     * @param userCollectInfo 用户访问记录
     * @return 结果
     */
    public int updateUserCollectInfo(UserCollectInfo userCollectInfo);

    /**
     * 批量删除用户访问记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserCollectInfoByIds(String ids);

    /**
     * 删除用户访问记录信息
     * 
     * @param id 用户访问记录ID
     * @return 结果
     */
    public int deleteUserCollectInfoById(Long id);

    /**
     * 获取是否喜欢
     * @param userId
     * @param id
     * @return
     */
    Boolean isLike(Long userId, Long id);

    /**
     * 是否收藏
     * @param userId
     * @param id
     * @return
     */
    Boolean isFavorite(Long userId, Long id);
}
