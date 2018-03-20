package com.tz.shopping.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.shopping.dao.ProductDao;
import com.tz.shopping.entity.Product;
import com.tz.shopping.service.ProductService;

//spring测试类的启动方式
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class TestSpringService {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDao productDao;

	@Test
	public void testService() {
		List<Product> list = productService.listProduct(1);
		for(Product p : list){
			System.out.println(p.getPname());
		}
	}
	
	@Test
	public void testDao() {
		List<Product> list = productDao.findByCategoryId(1, 1);
		for(Product p : list){
			System.out.println(p.getPname());
		}
	}
}
