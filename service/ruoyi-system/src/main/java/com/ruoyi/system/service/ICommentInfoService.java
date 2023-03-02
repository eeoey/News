package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CommentInfo;
import com.ruoyi.system.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

/**
 * 评论管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface ICommentInfoService 
{
    /**
     * 查询评论管理
     * 
     * @param id 评论管理ID
     * @return 评论管理
     */
    public CommentInfo selectCommentInfoById(Long id);

    /**
     * 获取文章的评论
     * @param id 文章ID
     * @param userId 用户ID
     * @return
     */
    List<CommentVO>  selectCommentVoByArticleId(Long id, Long userId);

    CommentVO selectCommentVoByIdAndUserId(Long id, Long userId);

    List<CommentVO> selectDetailVoByIdAndUserId(Long id, Long userId);
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
     * 批量删除评论管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommentInfoByIds(String ids);

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理ID
     * @return 结果
     */
    public int deleteCommentInfoById(Long id);

    int addLikeCount(Integer count,Long id);
    int addReplyCount(Integer count,Long id);
}
