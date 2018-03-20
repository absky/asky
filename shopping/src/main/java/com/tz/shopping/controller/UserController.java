package com.tz.shopping.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.shopping.entity.User;
import com.tz.shopping.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 客户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, String checkcode, HttpSession session, Map<String, Object> map) {
		System.out.println("前端验证码" + checkcode);
		/**
		 * 校验验证码
		 */
		String checkCode = (String) session.getAttribute("checkcode");
		System.out.println("后端验证码" + checkCode);
		// 如果验证码不一致，直接返回
		if (checkCode == null || !checkCode.equalsIgnoreCase(checkcode)) {
			map.put("errorCheckCode", "errorCheckCode");
			return "login";
		}
		/**
		 * 判断是否存在该用户,用客户名称校验客户是否存
		 */
		System.out.println(user.getUserName());
		User existUser = userService.existUser(user.getUserName());
	
		if(existUser == null){
			map.put("noUser", "noUser");
			return "login";
		}
		/**
		 * 判断用户和密码是否正确
		 */
		User tUser = userService.findByUserNameAndPassword(user);
		System.out.println(tUser);
		if(tUser == null){
			map.put("noPassword", "noPassword");
			return "login";
		}
		
		/**
		 * 把user对象放入到session范围
		 */
		session.setAttribute("user", tUser);
		System.out.println("Session : " + session.getAttribute("user"));
		return "redirect:index";
	}
	
	/**
	 * 客户退出
	 */
	@RequestMapping(value = "/quit", method = RequestMethod.GET)
	public String quit(HttpSession session){
		session.invalidate();
		return "redirect:index";
	}

	/**
	 * 客户注册
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, HttpSession session, String checkcode, Map<String, Object> map) {

		System.out.println(user);
		System.out.println("前端验证码" + checkcode);
		// 从session中取到验证码
		String checkCode = (String) session.getAttribute("checkcode");
		System.out.println("后端验证码" + checkCode);
		// 如果验证码不一致，直接返回
		if (!checkCode.equalsIgnoreCase(checkcode)) {
			map.put("errorCheckCode", "errorCheckCode");
			return "regist";
		}
		userService.registerUser(user);
		map.put("registerok", user.getUserName() + "注册成功，请登录");
		return "login";

	}

	/**
	 * 用ajax来判断用户是否存在
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkUser/{userName}", method = RequestMethod.POST)
	@ResponseBody
	public String existUser(@PathVariable("userName") String userName, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("===" + userName);
		if (userService.existUser(userName) != null) {
			// 客户已存在
			response.getWriter().println("1");
		} else {
			// 客户不存在
			response.getWriter().println("0");
		}
		return null;
	}

}
