package com.tz.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 客户卡包表
 * @author YT
 *
 */
@Table(name = "packet")
@Entity
public class Packet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pacid")
    private Integer pacid;

    /**
     * 客户外键
     */
    @OneToOne
    @JoinColumn(name = "uid", unique = true, nullable = false, updatable = false, insertable = false)
    private User user;

	public Integer getPacid() {
		return pacid;
	}

	public void setPacid(Integer pacid) {
		this.pacid = pacid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
