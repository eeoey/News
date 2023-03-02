package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CategoryInfo;

/**
 * 分类管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface ICategoryInfoService 
{
    /**
     * 查询分类管理
     * 
     * @param id 分类管理ID
     * @return 分类管理
     */
    public CategoryInfo selectCategoryInfoById(Long id);

    /**
     * 查询分类管理列表
     * 
     * @param categoryInfo 分类管理
     * @return 分类管理集合
     */
    public List<CategoryInfo> selectCategoryInfoList(CategoryInfo categoryInfo);

    /**
     * 新增分类管理
     * 
     * @param categoryInfo 分类管理
     * @return 结果
     */
    public int insertCategoryInfo(CategoryInfo categoryInfo);

    /**
     * 修改分类管理
     * 
     * @param categoryInfo 分类管理
     * @return 结果
     */
    public int updateCategoryInfo(CategoryInfo categoryInfo);

    /**
     * 批量删除分类管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCategoryInfoByIds(String ids);

    /**
     * 删除分类管理信息
     * 
     * @param id 分类管理ID
     * @return 结果
     */
    public int deleteCategoryInfoById(Long id);
}
