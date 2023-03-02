package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserCollectInfoMapper;
import com.ruoyi.system.domain.UserCollectInfo;
import com.ruoyi.system.service.IUserCollectInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户访问记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class UserCollectInfoServiceImpl implements IUserCollectInfoService
{
    @Autowired
    private UserCollectInfoMapper userCollectInfoMapper;

    /**
     * 查询用户访问记录
     * 
     * @param id 用户访问记录ID
     * @return 用户访问记录
     */
    @Override
    public UserCollectInfo selectUserCollectInfoById(Long id)
    {
        return userCollectInfoMapper.selectUserCollectInfoById(id);
    }

    /**
     * 查询用户访问记录列表
     * 
     * @param userCollectInfo 用户访问记录
     * @return 用户访问记录
     */
    @Override
    public List<UserCollectInfo> selectUserCollectInfoList(UserCollectInfo userCollectInfo)
    {
        return userCollectInfoMapper.selectUserCollectInfoList(userCollectInfo);
    }

    @Override
    public UserCollectInfo selectUserCollectionByParam(UserCollectInfo param) {
        List<UserCollectInfo> list = selectUserCollectInfoList(param);
        if(list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    /**
     * 新增用户访问记录
     * 
     * @param userCollectInfo 用户访问记录
     * @return 结果
     */
    @Override
    public int insertUserCollectInfo(UserCollectInfo userCollectInfo)
    {
        userCollectInfo.setCreateTime(DateUtils.getNowDate());
        return userCollectInfoMapper.insertUserCollectInfo(userCollectInfo);
    }

    /**
     * 修改用户访问记录
     * 
     * @param userCollectInfo 用户访问记录
     * @return 结果
     */
    @Override
    public int updateUserCollectInfo(UserCollectInfo userCollectInfo)
    {
        return userCollectInfoMapper.updateUserCollectInfo(userCollectInfo);
    }

    /**
     * 删除用户访问记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserCollectInfoByIds(String ids)
    {
        return userCollectInfoMapper.deleteUserCollectInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户访问记录信息
     * 
     * @param id 用户访问记录ID
     * @return 结果
     */
    @Override
    public int deleteUserCollectInfoById(Long id)
    {
        return userCollectInfoMapper.deleteUserCollectInfoById(id);
    }

    public Boolean isFavorite(Long userId, Long id) {
        UserCollectInfo param = new UserCollectInfo();
        param.setUserId(userId);
        param.setcId(id);
        param.setType(1);
        return !userCollectInfoMapper.selectUserCollectInfoList(param).isEmpty();
    }

    public Boolean isLike(Long userId, Long id) {
        UserCollectInfo param = new UserCollectInfo();
        param.setUserId(userId);
        param.setcId(id);
        param.setType(2);
        return !userCollectInfoMapper.selectUserCollectInfoList(param).isEmpty();
    }
}
