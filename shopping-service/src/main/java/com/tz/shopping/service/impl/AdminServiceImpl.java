package com.tz.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tz.shopping.dao.AdminDao;
import com.tz.shopping.entity.Admin;
import com.tz.shopping.service.AdminService;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	/**
	 * 根据用户 名和密码查询
	 */
	@Override
	public Admin checkUser(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.findByUserNameAndPwd(admin.getUsername(), admin.getPassword());
	}
	@Override
	public Admin getAdmin(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.get(id);
	}

}
