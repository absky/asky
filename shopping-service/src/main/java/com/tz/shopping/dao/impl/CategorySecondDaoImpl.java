package com.tz.shopping.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tz.shopping.dao.CategorySecondDao;
import com.tz.shopping.entity.CategorySecond;

@Repository("categorySecondDao")
public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao {

	@Override
	public Integer countCategorySecond() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from CategorySecond";
        return count(hql);
	}

	@Override
	public List<CategorySecond> findAll(Integer page) {
		// TODO Auto-generated method stub
		String hql = "from CategorySecond";
        int rows = 10;
        int page1 = page;
        return find(hql, page1, rows);
	}

	@Override
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		String hql = "from CategorySecond";
		return find(hql);
	}

}
