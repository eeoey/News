package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.controller.UserCollectInfoController;
import com.ruoyi.system.domain.UserCollectInfo;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.mapper.UserCollectInfoMapper;
import com.ruoyi.system.mapper.UserInfoMapper;
import com.ruoyi.system.recommend.analyzer.CollaborativeFilteringAnalyzer;
import com.ruoyi.system.recommend.bean.BasicBean;
import com.ruoyi.system.recommend.bean.HabitsBean;
import com.ruoyi.system.recommend.recommender.UserRecommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ContentInfoMapper;
import com.ruoyi.system.domain.ContentInfo;
import com.ruoyi.system.service.IContentInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 新闻管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class ContentInfoServiceImpl implements IContentInfoService {

    private final ContentInfoMapper contentInfoMapper;

    private final UserCollectInfoMapper collectInfoMapper;
    private final UserInfoMapper userInfoMapper;

    public ContentInfoServiceImpl(ContentInfoMapper contentInfoMapper, UserCollectInfoMapper collectInfoMapper, UserInfoMapper userInfoMapper) {
        this.contentInfoMapper = contentInfoMapper;
        this.collectInfoMapper = collectInfoMapper;
        this.userInfoMapper = userInfoMapper;
    }

    /**
     * 查询新闻管理
     *
     * @param id 新闻管理ID
     * @return 新闻管理
     */
    @Override
    public ContentInfo selectContentInfoById(Long id) {
        return contentInfoMapper.selectContentInfoById(id);
    }

    /**
     * 查询新闻管理列表
     *
     * @param contentInfo 新闻管理
     * @return 新闻管理
     */
    @Override
    public List<ContentInfo> selectContentInfoList(ContentInfo contentInfo) {
        return contentInfoMapper.selectContentInfoList(contentInfo);
    }

    @Override
    public List<ContentInfo> searchList(String keyword) {
        return contentInfoMapper.searchByKeyword(keyword);
    }

    @Override
    public List<ContentInfo> recommend(Long userId) {
        // 查询所有新闻
        List<ContentInfo> newsList = contentInfoMapper.selectContentInfoList(new ContentInfo());
        List<UserInfo> userList = userInfoMapper.selectUserInfoList(new UserInfo());
        double[][] score = new double[userList.size()][newsList.size()];
        List<UserCollectInfo> userCollectInfoList = collectInfoMapper.selectUserCollectInfoList(new UserCollectInfo());
        int index = 0;
        // 循环遍历所有的点赞收藏记录，如果用户点赞收藏某个新闻，那对应位置的分数则为+1
        for (UserCollectInfo item : userCollectInfoList) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getId().equals(userId)) {
                    // 获取到当前用户所对应的那一行数据，用于后面计算时可以排除该该列数据
                    index = i;
                }
                for (int j = 0; j < newsList.size(); j++) {
                    long itemUserId = item.getUserId();
                    long itemProductId = item.getcId();
                    if (userList.get(i).getId().equals(itemUserId) && newsList.get(j).getId().equals(itemProductId)) {
                        score[i][j] += 1d;
                        break;
                    }
                }
            }
        }
        List<ScoreDto> similarScoreList = new ArrayList<>();
        double[] arr = score[index];
        // 在这里通过余弦公式计算用户相似度
        for (int i = 0; i < score.length; i++) {
            // 这个判断是用于过滤自己的，因为自己不能跟自己比，不然相似度肯定是为1
            if (i == index) {
                continue;
            }
            // 分子
            double molecule =0;
            double denominator1 = 0;
            double denominator2 = 0;
            for (int k = 0; k < arr.length; k++) {
                denominator1 += Math.pow(arr[k], 2);
                denominator2 += Math.pow(score[i][k], 2);
                molecule += arr[k] * score[i][k];
            }

            // 分母
            double denominator = Math.sqrt(denominator1) * Math.sqrt(denominator2);
            if (denominator != 0) {
                double resultScore = molecule / denominator;
                ScoreDto scoreDto = new ScoreDto();
                scoreDto.setUserId(userList.get(i).getId());
                scoreDto.setScore(resultScore);
                similarScoreList.add(scoreDto);
            }
        }
        similarScoreList.sort((o1, o2) -> o2.getScore().compareTo(o1.getScore()));
        similarScoreList.forEach(item -> System.out.println("相似用户id：" + item.getUserId()  + " ---> 相似度分数：" + item.getScore()));
        // 取出相似度分数最高的用户所喜欢新闻推荐给当前用户
        List<Long> recommendNewsIdList = new ArrayList<>();
        for (ScoreDto scoreDto : similarScoreList) {
            for (UserCollectInfo item : userCollectInfoList) {
                if (item.getUserId().equals(scoreDto.getUserId())) {
                    recommendNewsIdList.add(item.getcId());
                }
            }
        }
        // 获取当前用户他所点赞收藏的新闻，操作过就不再推荐了
        List<Long> currentUserLikeIdList = new ArrayList<>();
        for (UserCollectInfo item : userCollectInfoList) {
            if (item.getUserId().equals(userId)) {
                currentUserLikeIdList.add(item.getcId());
            }
        }
        recommendNewsIdList = recommendNewsIdList.stream().distinct().collect(Collectors.toList());
        recommendNewsIdList = recommendNewsIdList.stream().filter(item -> !currentUserLikeIdList.contains(item)).collect(Collectors.toList());

        System.out.println("推荐新闻id：" + recommendNewsIdList);

        List<ContentInfo> list = recommendNewsIdList.stream().map(contentInfoMapper::selectContentInfoById)
                .collect(Collectors.toList());
        if (list.size() >= 20) {
            return list;
        }
        list = new ArrayList<>(list);
        List<ContentInfo> finalList = list;
        List<ContentInfo> supplement = selectContentInfoList(new ContentInfo()).stream()
                .filter(r-> finalList.stream().noneMatch(p-> p.getId().equals(r.getId())))
                .sorted(Comparator.comparing(ContentInfo::getRead).reversed())
                .limit(20 - list.size()).collect(Collectors.toList());
        list.addAll(supplement);
        return list;
    }

    static class ScoreDto {
        long userId;
        private Double score;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }
    }

    /**
     * 新增新闻管理
     *
     * @param contentInfo 新闻管理
     * @return 结果
     */
    @Override
    public int insertContentInfo(ContentInfo contentInfo) {
        contentInfo.setCreateTime(DateUtils.getNowDate());
        return contentInfoMapper.insertContentInfo(contentInfo);
    }

    /**
     * 修改新闻管理
     *
     * @param contentInfo 新闻管理
     * @return 结果
     */
    @Override
    public int updateContentInfo(ContentInfo contentInfo) {
        return contentInfoMapper.updateContentInfo(contentInfo);
    }

    /**
     * 删除新闻管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteContentInfoByIds(String ids) {
        return contentInfoMapper.deleteContentInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新闻管理信息
     *
     * @param id 新闻管理ID
     * @return 结果
     */
    @Override
    public int deleteContentInfoById(Long id) {
        return contentInfoMapper.deleteContentInfoById(id);
    }

    @Override
    public void addCommentCount(Integer count, Long id) {
        contentInfoMapper.addCommentCount(count, id);
    }

    @Override
    public void addLikeCount(Integer count, Long id) {
        contentInfoMapper.addLikeCount(count, id);
    }

    @Override
    public void addRead(Long id) {
        contentInfoMapper.addRead(id);
    }
}
