package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 店铺-商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public class StoreGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private String storeGoodsId;
	//店铺id
	private String storeId;
	//商品id
	private String goodsId;
	//分类id
	private String goodscategoryId;
	//图片
	private String img;
	//名称
	private String title;
	//库存
	private Integer total;
	//销量
	private Integer sales;
	//价格
	private BigDecimal marketprice;
	//原价格
	private BigDecimal originalprice;
	//销售状态
	private Integer salesStatus;
	

	/**
	 * 设置：
	 */
	public void setStoreGoodsId(String storeGoodsId) {
		this.storeGoodsId = storeGoodsId;
	}
	/**
	 * 获取：
	 */
	public String getStoreGoodsId() {
		return storeGoodsId;
	}
	/**
	 * 设置：店铺id
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	/**
	 * 获取：店铺id
	 */
	public String getStoreId() {
		return storeId;
	}
	/**
	 * 设置：商品id
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品id
	 */
	public String getGoodsId() {
		return goodsId;
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
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	public Integer getSalesStatus() {
		return salesStatus;
	}
	public void setSalesStatus(Integer salesStatus) {
		this.salesStatus = salesStatus;
	}
	public String getGoodscategoryId() {
		return goodscategoryId;
	}
	public void setGoodscategoryId(String goodscategoryId) {
		this.goodscategoryId = goodscategoryId;
	}
	public BigDecimal getOriginalprice() {
		return originalprice;
	}
	public void setOriginalprice(BigDecimal originalprice) {
		this.originalprice = originalprice;
	}
	
	
}
