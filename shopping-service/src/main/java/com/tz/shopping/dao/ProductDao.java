package com.tz.shopping.dao;

import java.util.List;

import com.tz.shopping.entity.Product;

public interface ProductDao extends BaseDao<Product>{
	
	/**
     * 查询二级分类的总的个数
     *
     * @return
     */
    public Integer countProduct();

    /**
     * 分页查找所有二级分类
     *
     * @param page
     * @return
     */
    public List<Product> findAll(Integer page);
    
    public List<Product> findHot();

    public List<Product> findNew();
    
    /**
	 * 根据一级分类查询商品
	 */
	public List<Product> findByCategoryId(Integer cid, Integer page);
	
	/**
	 * 根据一级分类查询商品总页数
	 */
	public Integer CountPageProductFromCategory(Integer cid);
    
    

}
