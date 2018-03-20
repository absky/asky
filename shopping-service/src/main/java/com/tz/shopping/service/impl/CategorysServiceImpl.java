package com.tz.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tz.shopping.dao.CategorysDao;
import com.tz.shopping.entity.Categorys;
import com.tz.shopping.service.CategorysService;


@Service("categorysService")
@Transactional
public class CategorysServiceImpl implements CategorysService{
	
	@Autowired
	private CategorysDao categorysDao;

	/**
	 * 查询一级分类的页数
	 */
	@Override
	public Integer countCategory() {
		// TODO Auto-generated method stub
		Integer count = categorysDao.countCategory();
		/**
		 * 从总数得到出总页数
		 */
        return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
	}

	/**
	 * 当前页一级类目列表
	 */
	@Override
	public List<Categorys> listCategory(Integer page) {
		// TODO Auto-generated method stub
		return categorysDao.findAll(page);
	}

	@Override
	public void addCategory(Categorys category) {
		// TODO Auto-generated method stub
		categorysDao.save(category);
	}

	@Override
	public Categorys findCategory(Integer cid) {
		// TODO Auto-generated method stub
		return categorysDao.get(cid);
	}

	@Override
	public void updateCategory(Categorys category) {
		// TODO Auto-generated method stub
		categorysDao.update(category);
	}

	@Override
	public void deleteCategory(Integer cid) {
		// TODO Auto-generated method stub
		categorysDao.delete(cid);
	}

	@Override
	public List<Categorys> findAll() {
		// TODO Auto-generated method stub
		return categorysDao.findAll();
	}

}
