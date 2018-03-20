package com.tz.shopping.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tz.shopping.dao.CategorysDao;
import com.tz.shopping.entity.Categorys;

@Repository("categoryDao")
public class CategorysDaoImpl extends BaseDaoImpl<Categorys> implements CategorysDao {

	@Override
	public Integer countCategory() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Categorys";
		return count(hql);
	}

	@Override
	public List<Categorys> findAll(Integer page) {
		// TODO Auto-generated method stub
		String hql = "from Categorys";
        int rows = 10;
        return find(hql, page, rows);
	}

	@Override
	public List<Categorys> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Categorys";
		return find(hql);
	}


}
