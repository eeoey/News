package com.ruoyi.system.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CategoryInfoMapper;
import com.ruoyi.system.domain.CategoryInfo;
import com.ruoyi.system.service.ICategoryInfoService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.web.util.HtmlUtils;

/**
 * 分类管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class CategoryInfoServiceImpl implements ICategoryInfoService {
    @Autowired
    private CategoryInfoMapper categoryInfoMapper;

    /**
     * 查询分类管理
     *
     * @param id 分类管理ID
     * @return 分类管理
     */
    @Override
    public CategoryInfo selectCategoryInfoById(Long id) {
        return categoryInfoMapper.selectCategoryInfoById(id);
    }

    /**
     * 查询分类管理列表
     *
     * @param categoryInfo 分类管理
     * @return 分类管理
     */
    @Override
    public List<CategoryInfo> selectCategoryInfoList(CategoryInfo categoryInfo) {
        return categoryInfoMapper.selectCategoryInfoList(categoryInfo)
                .stream()
                .sorted(Comparator.comparing(CategoryInfo::getSort))
                .collect(Collectors.toList());
    }

    /**
     * 新增分类管理
     *
     * @param categoryInfo 分类管理
     * @return 结果
     */
    @Override
    public int insertCategoryInfo(CategoryInfo categoryInfo) {
        categoryInfo.setCreateTime(DateUtils.getNowDate());
        return categoryInfoMapper.insertCategoryInfo(categoryInfo);
    }

    /**
     * 修改分类管理
     *
     * @param categoryInfo 分类管理
     * @return 结果
     */
    @Override
    public int updateCategoryInfo(CategoryInfo categoryInfo) {
        return categoryInfoMapper.updateCategoryInfo(categoryInfo);
    }

    /**
     * 删除分类管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCategoryInfoByIds(String ids) {
        return categoryInfoMapper.deleteCategoryInfoByIds(Convert.toStrArray(ids));
    }


    /**
     * 删除分类管理信息
     *
     * @param id 分类管理ID
     * @return 结果
     */
    @Override
    public int deleteCategoryInfoById(Long id) {
        return categoryInfoMapper.deleteCategoryInfoById(id);
    }
}
