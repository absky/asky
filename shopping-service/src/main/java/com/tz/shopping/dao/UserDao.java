package com.tz.shopping.dao;

import com.tz.shopping.entity.User;

/**
 * 客户的Dao接口
 * @author YT
 *
 */
public interface UserDao extends BaseDao<User>{
	
	/**
	 * 根据用户名查询用户
	 */
	public User findByUserName(String userName);
	
	/**
	 * 根据用户名和密码查询用户
	 */
	public User findByUserNameAndPassword(String userName, String password);

}
