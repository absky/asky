package com.tz.shopping.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tz.shopping.entity.Admin;
import com.tz.shopping.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	/**
	 * 跳转到商城管理系统 的首页
	 */
	@RequestMapping(value="/admin")
	public String adminIndex(){
		
		return "admin/login";
	}
	
	/**
	 * 处理登录页面
	 */
	@RequestMapping(value="/adminLogin", method=RequestMethod.POST)
	public String adminLogin(Admin admin, HttpSession session, Map<String, Object> map){
		if(admin.getUsername().isEmpty() || admin.getPassword().isEmpty()){
			map.put("loginFlag", "用户名或密码不能为空");
			return "admin/login";
		}
		Admin user = adminService.checkUser(admin);
		if(user == null){
			map.put("loginFlag", "错误的用户名和密码");
			return "admin/login";
		}else{
			session.setAttribute("admin", admin);
		}
		return "admin/home";
	}
	
	/**
	 * 退出登录 
	 */
	@RequestMapping("/adminOut")
	public String adminOut(HttpSession session){
		session.invalidate();
		return "admin/login";
	}
	
	/**
	 * 顶部页面
	 */
	@RequestMapping("/adminTop")
	public String adminTop(){
		return "admin/top";
	}
	
	/**
	 * 左侧页面
	 */
	@RequestMapping("/adminLeft")
	public String adminLeft(){
		return "admin/left_1";
	}
	
	/**
	 * 左侧页面
	 */
	@RequestMapping("/adminWelcome")
	public String adminWelcome(){
		return "admin/welcome";
	}
	
	/**
	 * 底部页面
	 */
	@RequestMapping("/adminBottom")
	public String adminBottom(){
		return "admin/bottom";
	}
	
	
	/**
	 * =====================会员管理的控制层=========================
	 */
	@RequestMapping("/listUser/{page}")
	public String listUser(@PathVariable("page") Integer page){
		
		return "admin/user/list";
	}
	
}
