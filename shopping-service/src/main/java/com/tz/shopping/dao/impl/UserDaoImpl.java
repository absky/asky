package com.tz.shopping.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.tz.shopping.dao.UserDao;
import com.tz.shopping.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		String hql ="from User u where u.userName = :username";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter("username", userName);
		return (User) query.uniqueResult();
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.userName = :username and u.password = :password";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		return (User) query.uniqueResult();
	}

}
