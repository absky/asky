package com.tz.shopping.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 一级类目实体类
 * 
 * @author YT
 *
 */
@Table(name = "category")
@Entity
public class Categorys implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private Integer cid;

	@Column(name = "cname", nullable = false, length = 255)
	private String cname;

	@Column(name = "discount")
	private float discount;

	@Column(name = "privilegetime")
	private Date privilegeTime;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private Set<CategorySecond> categorySeconds;

	@OneToOne(cascade = {CascadeType.REFRESH }, fetch = FetchType.EAGER, mappedBy = "category")
	private Ticket ticket;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Date getPrivilegeTime() {
		return privilegeTime;
	}

	public void setPrivilegeTime(Date privilegeTime) {
		this.privilegeTime = privilegeTime;
	}

	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
