package com.tz.shopping.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 优惠券表
 * @author YT
 *
 */
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tid")
    private Integer tid;
	
	@Column(name="privilege")
    private Float privilege;
    
	@Column(name="consume")
    private Float consume;
    
	@Column(name="use_time")
    private Date useTime;

    @OneToOne
    @JoinColumn(name = "cid", unique = true, nullable = false, updatable = false, insertable = false)
    private Categorys category;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Float getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Float privilege) {
		this.privilege = privilege;
	}

	public Float getConsume() {
		return consume;
	}

	public void setConsume(Float consume) {
		this.consume = consume;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public Categorys getCategory() {
		return category;
	}

	public void setCategory(Categorys category) {
		this.category = category;
	}
    
}

