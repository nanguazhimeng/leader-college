package com.ms1491.modules.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 店铺订单
 * @author Administrator
 * 2017年09月28日
 */
public class StoreOrderEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//支付状态：-1（退款），0（未付款），1（已完成），2（待发货），3（待收货）
	private String status;
	//价格
	private BigDecimal price;
	//创建时间
	private String createTime;
	//订单号
	private String outTradeNo;
	//商品图片
	private String img;
	//商品名称
	private String title;
	//
	private Integer total;
	//
	private Integer sales;
	//所属店铺
	private String storeName;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	
}
