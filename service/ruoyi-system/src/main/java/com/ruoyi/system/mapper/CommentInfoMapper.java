package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CommentInfo;
import com.ruoyi.system.vo.CommentVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 评论管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Repository
public interface CommentInfoMapper 
{
    /**
     * 查询评论管理
     * 
     * @param id 评论管理ID
     * @return 评论管理
     */
    public CommentInfo selectCommentInfoById(Long id);

    /**
     * 获取评论详情
     * @param id
     * @param userId
     * @return
     */
    public CommentVO selectCommentVoByIdAndUserId(Long id, Long userId);

    /**
     * 获取文章评论
     * @param cid 文章ID
     * @param userId 用户ID
     * @return
     */
    List<CommentVO> getList(@Param("cid") Long cid, @Param("userId") Long userId);

    /**
     * 获取评论回复
     * @param id 评论ＩＤ
     * @param userId 用户ID
     * @return
     */
    List<CommentVO> getDetailList(@Param("id") Long id, @Param("userId") Long userId);
    /**
     * 查询评论管理列表
     * 
     * @param commentInfo 评论管理
     * @return 评论管理集合
     */
    public List<CommentInfo> selectCommentInfoList(CommentInfo commentInfo);

    /**
     * 新增评论管理
     * 
     * @param commentInfo 评论管理
     * @return 结果
     */
    public int insertCommentInfo(CommentInfo commentInfo);

    /**
     * 修改评论管理
     * 
     * @param commentInfo 评论管理
     * @return 结果
     */
    public int updateCommentInfo(CommentInfo commentInfo);

    /**
     * 删除评论管理
     * 
     * @param id 评论管理ID
     * @return 结果
     */
    public int deleteCommentInfoById(Long id);

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommentInfoByIds(String[] ids);


    @Update("UPDATE comment_info set like_count=like_count+(#{count}) where id=#{id}")
    int addLikeCount(@Param("count") Integer count, @Param("id") Long id);

    @Update("UPDATE comment_info set reply_count=reply_count+(#{count}) where id=#{id}")
    int addReplyCount(@Param("count") Integer count, @Param("id") Long id);
}
