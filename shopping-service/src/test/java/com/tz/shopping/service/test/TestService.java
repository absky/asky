package com.tz.shopping.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tz.shopping.dao.AdminDao;
import com.tz.shopping.entity.Admin;

/**
 * Spring的测试类
 * @author YT
 *
 */
public class TestService {
	
	private ApplicationContext ctx;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-context.xml");
	}
	
	@Test
	public void test(){
		AdminDao adminDao = (AdminDao) ctx.getBean("adminDao");
		
		Admin admin = adminDao.get(1);
		
		System.out.println(admin);
	}
	
	@Test
	public void testEmpty(){
		String dd = null;
		System.out.println(dd.isEmpty());
	}

}
