package com.tz.shopping.service;

import java.util.List;

import com.tz.shopping.entity.Product;

public interface ProductService {
	
	/**
	 * 查询商品的页数
	 */
	public Integer countProductPage();
	
	/**
	 * 分页显示商品
	 * @param page
	 * @return
	 */
	public List<Product> listProduct(Integer page);
	
	/**
	 * 保存商品
	 */
	public void saveProduct(Product product);
	
	/**
	 * 得到一个商品
	 */
	public Product getProduct(Integer pid);
	
	/**
	 * 删除一个商品
	 */
	public void deleteProduct(Product product);
	
	/**
	 * 保存商品
	 */
	public void updateProduct(Product product);
	
	/**
	 * 查找最新的商品10条
	 */
	public List<Product> findNew();
	
	/**
	 * 查找最热的商品10条
	 * @return
	 */
	public List<Product> findHot();
	
	/**
	 * ================================================
	 */
	
	/**
	 * 根据一级分类查询商品
	 */
	public List<Product> findByCid(Integer cid, Integer page);
	
	/**
	 * 根据一级分类查询商品总页数
	 */
	public Integer CountPageProductFromCategory(Integer cid);

}
