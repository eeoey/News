package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ContentInfo;

/**
 * 新闻管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface IContentInfoService 
{
    /**
     * 查询新闻管理
     * 
     * @param id 新闻管理ID
     * @return 新闻管理
     */
    public ContentInfo selectContentInfoById(Long id);

    /**
     * 查询新闻管理列表
     * 
     * @param contentInfo 新闻管理
     * @return 新闻管理集合
     */
    public List<ContentInfo> selectContentInfoList(ContentInfo contentInfo);

    public List<ContentInfo> searchList(String keyword);

    /**
     * 获取推荐阅读的文章
     * @param userId
     * @return
     */
    public List<ContentInfo> recommend(Long userId);
    /**
     * 新增新闻管理
     * 
     * @param contentInfo 新闻管理
     * @return 结果
     */
    public int insertContentInfo(ContentInfo contentInfo);

    /**
     * 修改新闻管理
     * 
     * @param contentInfo 新闻管理
     * @return 结果
     */
    public int updateContentInfo(ContentInfo contentInfo);

    /**
     * 批量删除新闻管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteContentInfoByIds(String ids);

    /**
     * 删除新闻管理信息
     * 
     * @param id 新闻管理ID
     * @return 结果
     */
    public int deleteContentInfoById(Long id);

    void addCommentCount(Integer count, Long id);

    void addLikeCount(Integer count, Long id);

    void addRead(Long id);

}
