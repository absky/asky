package com.tz.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单项表
 * @author YT
 *
 */

@Entity
@Table(name = "orderitem")
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "itemid")
    private Integer itemId;

	/**
	 * 购买数量
	 */
	@Column(name="count")
    private Integer count;

	/**
	 * 小计
	 */
	@Column(name="subtotal")
    private Float subtotal;

	/**
	 * 商品的外键, 单向多对一
	 */
    @JoinColumn(name = "pid")
    @ManyToOne
    private Product product;

    /**
     * 订单外键
     */
    @JoinColumn(name = "oid")
    @ManyToOne
    private Order order;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
    
}
