package com.tz.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tz.shopping.dao.CategorySecondDao;
import com.tz.shopping.entity.CategorySecond;
import com.tz.shopping.service.CategorySecondService;

@Transactional
@Service("categorySecondService")
public class CategorySecondServiceImpl implements CategorySecondService {
	
	@Autowired
	 private CategorySecondDao categorySecondDao;

	@Override
	public Integer countCategoryPage() {
		// TODO Auto-generated method stub
		Integer count = categorySecondDao.countCategorySecond();
        return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
	}

	@Override
	public List<CategorySecond> listCategorySecond(Integer page) {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll(page);
	}

	@Override
	public void addCategorySecond(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.save(categorySecond);
	}

	@Override
	public CategorySecond findCategorySecond(Integer csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.get(csid);
	}

	@Override
	public void updateCategorySecond(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.update(categorySecond);
	}

	@Override
	public void deleteCategorySecond(Integer csid) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(csid);
	}

	@Override
	public List<CategorySecond> listCategorySecond() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	}

}
