package com.tz.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理平台用户表
 * @author YT
 *
 */

@Table(name="adminuser")
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	private Integer uid;
	
	@Column(name="username", nullable=false, length=32)
	private String username;
	
	@Column(name="password", nullable=false, length=32)
	private String password;
	
	@Column(name="minventory")
	private Integer minventory;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMinventory() {
		return minventory;
	}

	public void setMinventory(Integer minventory) {
		this.minventory = minventory;
	}

	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", username=" + username + ", password=" + password + ", minventory=" + minventory
				+ "]";
	}

}
