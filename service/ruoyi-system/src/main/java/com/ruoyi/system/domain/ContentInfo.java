package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 新闻管理对象 content_info
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public class ContentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 图片 */
    @Excel(name = "图片")
    private String photoUrl;

    /** 阅读数 */
    @Excel(name = "阅读数")
    private Integer read;

    /** 转载原文 */
    @Excel(name = "转载原文")
    private String source;

    /**  */
    @Excel(name = "")
    private Integer commentCount;

    /**  */
    @Excel(name = "")
    private Integer enable;

    /**  */
    @Excel(name = "")
    private Integer sort;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long categoryId;

    /** 上下文 */
    @Excel(name = "上下文")
    private String content;

    /** 简介 */
    @Excel(name = "简介")
    private String des;

    /** 转载原文链接 */
    @Excel(name = "转载原文链接")
    private String sourceUrl;

    /** 点赞数目 */
    @Excel(name = "点赞数目")
    private Integer likeCount;

    /**  */
    @Excel(name = "")
    private Integer slider;
    /**
     * 发布者Id
     */
    private Long userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date processingTime;

    /**
     * 是否审核
     */
    private Integer afterProcess;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPhotoUrl(String photoUrl) 
    {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() 
    {
        return photoUrl;
    }
    public void setRead(Integer read) 
    {
        this.read = read;
    }

    public Integer getRead() 
    {
        return read;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setCommentCount(Integer commentCount) 
    {
        this.commentCount = commentCount;
    }

    public Integer getCommentCount() 
    {
        return commentCount;
    }
    public void setEnable(Integer enable) 
    {
        this.enable = enable;
    }

    public Integer getEnable() 
    {
        return enable;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDes(String des) 
    {
        this.des = des;
    }

    public String getDes() 
    {
        return des;
    }
    public void setSourceUrl(String sourceUrl) 
    {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUrl() 
    {
        return sourceUrl;
    }
    public void setLikeCount(Integer likeCount) 
    {
        this.likeCount = likeCount;
    }

    public Integer getLikeCount() 
    {
        return likeCount;
    }
    public void setSlider(Integer slider) 
    {
        this.slider = slider;
    }

    public Integer getSlider() 
    {
        return slider;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("photoUrl", getPhotoUrl())
            .append("read", getRead())
            .append("createTime", getCreateTime())
            .append("source", getSource())
            .append("commentCount", getCommentCount())
            .append("enable", getEnable())
            .append("sort", getSort())
            .append("categoryId", getCategoryId())
            .append("content", getContent())
            .append("des", getDes())
            .append("sourceUrl", getSourceUrl())
            .append("likeCount", getLikeCount())
            .append("slider", getSlider())
            .toString();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Date processingTime) {
        this.processingTime = processingTime;
    }

    public Integer getAfterProcess() {
        return afterProcess;
    }

    public void setAfterProcess(Integer afterProcess) {
        this.afterProcess = afterProcess;
    }
}
