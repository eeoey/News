package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UserCollectInfo;
import org.springframework.stereotype.Repository;

/**
 * 用户访问记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Repository
public interface UserCollectInfoMapper 
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
     * 删除用户访问记录
     * 
     * @param id 用户访问记录ID
     * @return 结果
     */
    public int deleteUserCollectInfoById(Long id);

    /**
     * 批量删除用户访问记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserCollectInfoByIds(String[] ids);
}
