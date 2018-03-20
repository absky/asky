package com.tz.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tz.shopping.dao.ProductDao;
import com.tz.shopping.entity.Product;
import com.tz.shopping.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	public Integer countProductPage() {
		// TODO Auto-generated method stub
		Integer count = productDao.countProduct();
        return (count % 6 == 0 ? (count / 6) : (count / 6 + 1));
	}

	@Override
	public List<Product> listProduct(Integer page) {
		// TODO Auto-generated method stub
		return productDao.findAll(page);
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}

	@Override
	public Product getProduct(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.get(pid);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	@Override
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}

	@Override
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}

	@Override
	public List<Product> findByCid(Integer cid, Integer page) {
		// TODO Auto-generated method stub
		return productDao.findByCategoryId(cid, page);
	}

	@Override
	public Integer CountPageProductFromCategory(Integer cid) {
		// TODO Auto-generated method stub
		Integer count = productDao.CountPageProductFromCategory(cid);
		return (count % 12 == 0 ? (count / 12) : (count / 12 + 1));
	}
	
}
