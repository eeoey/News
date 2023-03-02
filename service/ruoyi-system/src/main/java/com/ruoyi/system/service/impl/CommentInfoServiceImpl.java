package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CommentInfoMapper;
import com.ruoyi.system.domain.CommentInfo;
import com.ruoyi.system.service.ICommentInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评论管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class CommentInfoServiceImpl implements ICommentInfoService {
    @Autowired
    private CommentInfoMapper commentInfoMapper;

    /**
     * 查询评论管理
     *
     * @param id 评论管理ID
     * @return 评论管理
     */
    @Override
    public CommentInfo selectCommentInfoById(Long id) {
        return commentInfoMapper.selectCommentInfoById(id);
    }

    @Override
    public List<CommentVO> selectCommentVoByArticleId(Long id, Long userId) {
        return commentInfoMapper.getList(id, userId);
    }

    @Override
    public CommentVO selectCommentVoByIdAndUserId(Long id, Long userId) {
        CommentVO result = commentInfoMapper.selectCommentVoByIdAndUserId(id, userId);
        return result;
    }

    @Override
    public List<CommentVO> selectDetailVoByIdAndUserId(Long id, Long userId) {
        return commentInfoMapper.getDetailList(id, userId);
    }

    /**
     * 查询评论管理列表
     *
     * @param commentInfo 评论管理
     * @return 评论管理
     */
    @Override
    public List<CommentInfo> selectCommentInfoList(CommentInfo commentInfo) {
        return commentInfoMapper.selectCommentInfoList(commentInfo);
    }

    /**
     * 新增评论管理
     *
     * @param commentInfo 评论管理
     * @return 结果
     */
    @Override
    public int insertCommentInfo(CommentInfo commentInfo) {
        commentInfo.setCreateTime(DateUtils.getNowDate());
        return commentInfoMapper.insertCommentInfo(commentInfo);
    }

    /**
     * 修改评论管理
     *
     * @param commentInfo 评论管理
     * @return 结果
     */
    @Override
    public int updateCommentInfo(CommentInfo commentInfo) {
        return commentInfoMapper.updateCommentInfo(commentInfo);
    }

    /**
     * 删除评论管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommentInfoByIds(String ids) {
        return commentInfoMapper.deleteCommentInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论管理信息
     *
     * @param id 评论管理ID
     * @return 结果
     */
    @Override
    public int deleteCommentInfoById(Long id) {
        return commentInfoMapper.deleteCommentInfoById(id);
    }

    @Override
    public int addLikeCount(Integer count, Long id) {
        return commentInfoMapper.addLikeCount(count, id);
    }

    @Override
    public int addReplyCount(Integer count, Long id) {
        return commentInfoMapper.addReplyCount(count, id);
    }
}
