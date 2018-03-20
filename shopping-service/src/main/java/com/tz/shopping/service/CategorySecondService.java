package com.tz.shopping.service;

import java.util.List;

import com.tz.shopping.entity.CategorySecond;

public interface CategorySecondService {
	
	
	/**
	 * 查询一级分类的页数
	 */
	public Integer countCategoryPage();
	
	/**
	 * 分页显示二级类目
	 * @param page
	 * @return
	 */
	public List<CategorySecond> listCategorySecond(Integer page);
	
	/**
	 * 保存二级分类
	 * @param categorySecond
	 */
	public void addCategorySecond(CategorySecond categorySecond);
	
	
	/**
	 * 查找具体某个二级分类
	 */
	 public CategorySecond findCategorySecond(Integer csid);
	 
	 
	 /**
	  * 更新二级分类
	  */
	 public void updateCategorySecond(CategorySecond categorySecond);
	 
	 /**
	  * 删除二级分类
	  */
	 public void deleteCategorySecond(Integer csid);
	 
	 /**
	  * 获取所有的二级类目
	  */
	 public List<CategorySecond> listCategorySecond();

}
