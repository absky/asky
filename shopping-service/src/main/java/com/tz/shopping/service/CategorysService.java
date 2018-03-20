package com.tz.shopping.service;

import java.util.List;

import com.tz.shopping.entity.Categorys;

public interface CategorysService {

	/**
	 * 查询一级分类的页数
	 */
	public Integer countCategory();

	/**
	 * 当前页一级类目列表
	 */
	public List<Categorys> listCategory(Integer page);
	
	/**
	 * 添加一级分类
	 */
	 public void addCategory(Categorys category);
	 
	 /**
	  * 查询某个具体的一级分类
	  */
	 public Categorys findCategory(Integer cid);
	 
	 /**
	  * 更新一级分类
	  */
	 public void updateCategory(Categorys category);
	 
	 /**
	  * 删除一级分类
	  */
	 public void deleteCategory(Integer cid);
	 
	 
	 public List<Categorys> findAll();
}
