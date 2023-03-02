package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 普通用户管理对象 user_info
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 头像 */
    @Excel(name = "头像")
    private String avatarUrl;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 三方ID */
    @Excel(name = "三方ID")
    private String openId;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private Integer enable;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setEnable(Integer enable) 
    {
        this.enable = enable;
    }

    public Integer getEnable() 
    {
        return enable;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickname", getNickname())
            .append("avatarUrl", getAvatarUrl())
            .append("createTime", getCreateTime())
            .append("gender", getGender())
            .append("openId", getOpenId())
            .append("enable", getEnable())
            .append("password", getPassword())
            .append("phoneNumber", getPhoneNumber())
            .toString();
    }
}
