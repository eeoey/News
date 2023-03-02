package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ContentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 新闻管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Repository
public interface ContentInfoMapper 
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

    /***
     * 根据关键字查询
     * @param keyword  查询关键字
     * @return 新闻集合
     */
    List<ContentInfo> searchByKeyword(String keyword);

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
     * 删除新闻管理
     * 
     * @param id 新闻管理ID
     * @return 结果
     */
    public int deleteContentInfoById(Long id);

    /**
     * 批量删除新闻管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteContentInfoByIds(String[] ids);

    @Update("UPDATE content_info set comment_count=comment_count+(#{count}) where id=#{id}")
    int addCommentCount(@Param("count") Integer count, @Param("id") Long id);

    @Update("UPDATE content_info set like_count=like_count+(#{count}) where id=#{id}")
    int addLikeCount(@Param("count") Integer count, @Param("id") Long id);

    @Update("UPDATE content_info set `read_count`=`read_count`+1 where id=#{id}")
    int addRead(Long id);
}
