package com.tz.shopping.dao;

import com.tz.shopping.entity.Admin;

/**
 * 系统用户Dao类的接口
 * @author YT
 *
 */
public interface AdminDao extends BaseDao<Admin> {
	
	/**
	 * 根据用户名和密码查找系统用户 对象
	 * 
	 */
	public Admin findByUserNameAndPwd(String username, String password);

}
