package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.user.UserNotExistsException;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.common.utils.DateUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserInfoMapper;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.IUserInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 普通用户管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询普通用户管理
     *
     * @param id 普通用户管理ID
     * @return 普通用户管理
     */
    @Override
    public UserInfo selectUserInfoById(Long id) {
        return userInfoMapper.selectUserInfoById(id);
    }

    private String encryptPassword(String password) {
        return new Md5Hash("WEB" + password + "WEB").toHex();
    }

    @Override
    public SysUser shiroLogin(String user, String password) {
        UserInfo param = new UserInfo();
        param.setPhoneNumber(user);
        UserInfo userInfo = userInfoMapper.selectUserInfoList(param)
                .stream().findFirst().orElse(null);
        if (userInfo == null) {
            throw new UserNotExistsException();
        }
        if (!userInfo.getPassword().equalsIgnoreCase(encryptPassword(password))) {
            throw new UserPasswordNotMatchException();
        }
        SysUser loginUser = new SysUser();
        loginUser.setLoginName(userInfo.getNickname());
        loginUser.setUserId(userInfo.getId());
        return loginUser;
    }

    @Override
    public void register(UserInfo user) {
        user.setPassword(encryptPassword(user.getPassword()));
        userInfoMapper.insertUserInfo(user);
    }


    /**
     * 查询普通用户管理列表
     *
     * @param userInfo 普通用户管理
     * @return 普通用户管理
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增普通用户管理
     *
     * @param userInfo 普通用户管理
     * @return 结果
     */
    @Override
    public int insertUserInfo(UserInfo userInfo) {
        userInfo.setCreateTime(DateUtils.getNowDate());
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改普通用户管理
     *
     * @param userInfo 普通用户管理
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public void changePassword(Long userId, String oldPwd, String newPwd) {
        UserInfo user = userInfoMapper.selectUserInfoById(userId);
        if(user == null){
            throw new UserNotExistsException();
        }
        if(!user.getPassword().equals(encryptPassword(oldPwd))){
            throw new UserPasswordNotMatchException();
        }
        user.setPassword(encryptPassword(newPwd));
        userInfoMapper.updateUserInfo(user);
    }

    /**
     * 删除普通用户管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserInfoByIds(String ids) {
        return userInfoMapper.deleteUserInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除普通用户管理信息
     *
     * @param id 普通用户管理ID
     * @return 结果
     */
    @Override
    public int deleteUserInfoById(Long id) {
        return userInfoMapper.deleteUserInfoById(id);
    }
}
