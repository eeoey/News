package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论管理对象 comment_info
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public class CommentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 回复数目 */
    @Excel(name = "回复数目")
    private Integer replyCount;

    /** 点赞数目 */
    @Excel(name = "点赞数目")
    private Integer likeCount;

    /** 回复评论ID */
    @Excel(name = "回复评论ID")
    private Long pid;

    /** 回复文章 */
    @Excel(name = "回复文章")
    private Long cId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setReplyCount(Integer replyCount) 
    {
        this.replyCount = replyCount;
    }

    public Integer getReplyCount() 
    {
        return replyCount;
    }
    public void setLikeCount(Integer likeCount) 
    {
        this.likeCount = likeCount;
    }

    public Integer getLikeCount() 
    {
        return likeCount;
    }
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setcId(Long cId) 
    {
        this.cId = cId;
    }

    public Long getcId() 
    {
        return cId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("replyCount", getReplyCount())
            .append("likeCount", getLikeCount())
            .append("pid", getPid())
            .append("cId", getcId())
            .toString();
    }
}
