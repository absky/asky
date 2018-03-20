package com.tz.shopping.dao;

import java.util.List;

import com.tz.shopping.entity.Categorys;

/**
 * 一级类目的Dao接口
 * @author YT
 *
 */
public interface CategorysDao extends BaseDao<Categorys> {

	/**
	 * 一级类目总数
	 * @return
	 */
	 public Integer countCategory();
	 
	 /**
	  * 分页查找一级类目
	  * @param page
	  * @return
	  */
	 public List<Categorys> findAll(Integer page);
	 
	 
	 public List<Categorys> findAll();
}
