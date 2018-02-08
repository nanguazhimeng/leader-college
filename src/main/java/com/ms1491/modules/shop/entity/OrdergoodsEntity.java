package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 订单商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public class OrdergoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer ordergoodsId;
	//订单号
	private Integer orderId;
	//商品id
	private Integer goodsId;
	//价格
	private BigDecimal price;
	//数量
	private Integer total;
	//规格
	private String items;
	//创建时间
	private String createTime;
	
	private String title;



	public Integer getOrdergoodsId() {
		return ordergoodsId;
	}
	public void setOrdergoodsId(Integer ordergoodsId) {
		this.ordergoodsId = ordergoodsId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 设置：数量
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	/**
	 * 获取：数量
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * 设置：规格
	 */
	public void setItems(String items) {
		this.items = items;
	}
	/**
	 * 获取：规格
	 */
	public String getItems() {
		return items;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
