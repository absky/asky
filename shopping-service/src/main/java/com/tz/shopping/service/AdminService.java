package com.tz.shopping.service;

import com.tz.shopping.entity.Admin;

public interface AdminService {
	
	public Admin checkUser(Admin admin);
	
	public Admin getAdmin(Integer id);

}
