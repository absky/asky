package com.tz.shopping.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 二级类目的实体类
 * @author YT
 *
 */
@Table(name="categorysecond")
@Entity
public class CategorySecond {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="csid")
	private Integer csId;
	
	@Column(name="csname", nullable=false, length=255)
	private String csName;
	
	@JoinColumn(name = "cid")
    @ManyToOne
    private Categorys category;
	
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy = "categorySecond")
	private Set<Product> products;

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public Categorys getCategory() {
		return category;
	}

	public void setCategory(Categorys category) {
		this.category = category;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
