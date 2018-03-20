package com.tz.shopping.service;

import com.tz.shopping.entity.User;

public interface UserService {
	
	/**
	 * 客户注册 
	 */
	public void registerUser(User user);
	
	/**
	 *判断客户是否存在
	 * @param userName
	 * @return
	 */
	public User existUser(String userName);
	
	/**
	 * 根据用户名和密码查询用户 
	 */
	public User findByUserNameAndPassword(User user);

}
