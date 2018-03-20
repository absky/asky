package com.tz.shopping.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tz.shopping.dao.AdminDao;
import com.tz.shopping.entity.Admin;

@Repository("adminDao")
@Transactional
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

	@Override
	public Admin findByUserNameAndPwd(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from Admin a where a.username= :username and a.password = :password";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (Admin) q.uniqueResult();
	}

	

}
