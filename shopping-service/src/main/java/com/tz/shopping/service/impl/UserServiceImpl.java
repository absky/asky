package com.tz.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tz.common.utils.MD5Utils;
import com.tz.common.utils.StringTools;
import com.tz.shopping.dao.UserDao;
import com.tz.shopping.entity.User;
import com.tz.shopping.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		String key = StringTools.getStringRamdom(6);
		user.setState(1);
		user.setCode(StringTools.getUUID());
		user.setKey(key);
		String pwd = MD5Utils.getMD5Str(user.getPassword() + user.getKey());
		user.setPassword(pwd);
		userDao.save(user);
	}

	@Override
	public User existUser(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(userName);
	}

	@Override
	public User findByUserNameAndPassword(User user) {
		// TODO Auto-generated method stub
		//user是多页面传入的参数的user对象
		//euser是数据库里存在user对象
		User euser = existUser(user.getUserName());
		String pwd = MD5Utils.getMD5Str(user.getPassword() + euser.getKey());
		return userDao.findByUserNameAndPassword(user.getUserName(), pwd);
	}

}
