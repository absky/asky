package com.tz.shopping.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tz.shopping.entity.Product;
import com.tz.shopping.service.ProductService;

/**
 * 商品的分类管理
 * @author YT
 *
 */
@Controller
public class PrdController {
	
	@Autowired
	private ProductService productService;
	
	
	/**
	 * 点击一级分类查询商品 {cid} : 一级类目的ID
	 * {page} : 当前页的页码
	 */
	@RequestMapping(value="/findByCid/{cid}/{page}")
	public String findByCid(@PathVariable("cid") Integer cid, @PathVariable("page") Integer page, 
			Map<String, Object> map){
		
		/**
		 * 当前页的商品的List
		 */
		List<Product> products = productService.findByCid(cid, page);
		
		/**
		 * 根据cid总页数
		 */
		Integer count = productService.CountPageProductFromCategory(cid);
		
		
		
		map.put("products", products);
		//当前页
		map.put("page", page);
		
		//总页数
		map.put("count", count);
		
		map.put("cid", cid);
		
		return "productlist";
	}
	
	
	/**
	 * 点击二级分类查询商品 {csid} : 二级类目的ID
	 * {page} : 当前页的页码
	 */
	@RequestMapping(value="/findByCsid/{csid}/{page}")
	public String findByCsid(){
		
		return "productlist";
	}
	
	/**
	 * 根据商品pid查询商品详情
	 */
	@RequestMapping(value="/findByPid/{pid}")
	public String findByPid(){
		
		return "product";
	}
	

}
