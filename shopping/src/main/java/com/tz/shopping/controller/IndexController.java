package com.tz.shopping.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tz.shopping.service.CategorysService;
import com.tz.shopping.service.ProductService;

/**
 * 商城首页
 * @author YT
 *
 */

@Controller
public class IndexController {
	
	@Resource
    private ProductService productService;
	
	
	@Resource
    private CategorysService categorysService;

	/**
	 * 商城首页
	 * @return
	 */
	@RequestMapping(value="/index")
	public String showIndex(Map<String, Object> map, HttpSession session){
		/**
		 * 把所有的商品分类都存放在session里
		 */
		session.setAttribute("cList", categorysService.findAll());
		
		/**
		 * 把最新的10条商品存放到map集合中
		 */
        map.put("nList", productService.findNew());
        /**
         * 把最热的10条商品添加到map集合中
         */
        map.put("hList", productService.findHot());
		return "index";
	}
	
	/**
	 * 跳转到用户登录
	 * @return
	 */
	@RequestMapping(value = "/userLogin")
    public String userLogin() {
        return "login";
    }
	
	/**
	 *  用户注册的跳转
	 * @return
	 */
	@RequestMapping("/userRegister")
    public String register() {
        return "regist";
    }
	
}
