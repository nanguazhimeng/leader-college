package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.ms1491.modules.api.utils.GoodscategoryResponse;



/**
 * 店铺管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public class StoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//店铺id
	private String storeId;
	//用户id
	private String uid;
	//图标
	private String icon;
	//名称
	private String name;
	//简介
	private String introduction;
	//联系电话
	private String phone;
	//店铺模板
	private String templateCode;
	//0没有权限，1未开店，2已开店
	private int status;
	//今日营收
	private BigDecimal todayPay = new BigDecimal("0");
	//累计金额
	private BigDecimal totalPay = new BigDecimal("0");
	//付款订单数
	private int orderCount = 0;
	
	private String ad;
	//fans
	private int fans;
	//全部商品个数
	private int total = 0;
	//上新个数
	private int newTotal = 0;
	//筛选
	private List<GoodscategoryEntity> goodscategoryList;
	//首页展示分类
	private List<GoodscategoryResponse> StoreGoodscategoryList;
	//最热，轮播
	private List<StoreGoodsEntity> storeHotGoodsList;
	//推荐
	private List<StoreGoodsEntity> storeRecommandGoodsList;
	
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
	 * 设置：用户id
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户id
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：简介
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：简介
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public List<GoodscategoryEntity> getGoodscategoryList() {
		return goodscategoryList;
	}
	public void setGoodscategoryList(List<GoodscategoryEntity> goodscategoryList) {
		this.goodscategoryList = goodscategoryList;
	}
	public BigDecimal getTodayPay() {
		return todayPay;
	}
	public void setTodayPay(BigDecimal todayPay) {
		this.todayPay = todayPay;
	}
	public BigDecimal getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(BigDecimal totalPay) {
		this.totalPay = totalPay;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNewTotal() {
		return newTotal;
	}
	public void setNewTotal(int newTotal) {
		this.newTotal = newTotal;
	}
	public List<GoodscategoryResponse> getStoreGoodscategoryList() {
		return StoreGoodscategoryList;
	}
	public void setStoreGoodscategoryList(
			List<GoodscategoryResponse> storeGoodscategoryList) {
		StoreGoodscategoryList = storeGoodscategoryList;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public List<StoreGoodsEntity> getStoreHotGoodsList() {
		return storeHotGoodsList;
	}
	public void setStoreHotGoodsList(List<StoreGoodsEntity> storeHotGoodsList) {
		this.storeHotGoodsList = storeHotGoodsList;
	}
	public List<StoreGoodsEntity> getStoreRecommandGoodsList() {
		return storeRecommandGoodsList;
	}
	public void setStoreRecommandGoodsList(
			List<StoreGoodsEntity> storeRecommandGoodsList) {
		this.storeRecommandGoodsList = storeRecommandGoodsList;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}

}
