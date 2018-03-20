package com.tz.shopping.dao;

import java.util.List;

import com.tz.shopping.entity.CategorySecond;

/**
 * 二级类目的Dao接口
 * @author YT
 *
 */
public interface CategorySecondDao extends BaseDao<CategorySecond> {

	/**
     * 查询二级分类的总的个数
     *
     * @return
     */
    public Integer countCategorySecond();

    /**
     * 分页查找所有二级分类
     *
     * @param page
     * @return
     */
    public List<CategorySecond> findAll(Integer page);
    
    
    /**
     * 获取所有的二级类目
     */
    public List<CategorySecond> findAll();
    
}
