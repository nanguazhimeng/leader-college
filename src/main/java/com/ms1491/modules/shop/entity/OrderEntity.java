package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 订单管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String orderId;
	//项目ID
	private String projectId;
	//支付状态：-1（退款），0（未付款），1（已完成），2（待发货），3（待收货）
	private String status;
	//openid
	private String openid;
	//项目名称
	private String projectName;
	//价格
	private BigDecimal price;
	//原价格
	private BigDecimal costprice;
	//商品价格
	private BigDecimal goodsprice;
	//打折抵扣
	private BigDecimal discount;
	//体验金抵扣
	private BigDecimal discounttestmoney;
	//创建时间
	private String createTime;
	//结束时间
	private String fintime;
	//用户id
	private String uid;
	//支付状态
	private String tradeState;
	//订单类型：shop表示商城，recharge表示充值，project表示购买专家课程,reward表示签到奖励
	//transfer表示转账,leader_shop表示leader商学院
	private String type;
	//专家名称
	private String expertName;
	//订单号
	private String outTradeNo;
	//评分
	private BigDecimal score;
	//评价
	private String msg;
	//评价时间
	private String scoreTime;
	//支付方式
	private String payType;
	//快递单号
	private String expressId;
	//快递公司
	private String expressCompany;
	//地址
	private String adress;
	//备注
	private String remark;
	//邮费
	private BigDecimal expressFee;
	//购物车id
	private String cartIds;
	//交易类型-收入支出
	private Integer transactionType;
	//店铺id
	private String storeId;

	
	private String username;
	
	private String phone;
	
	private String storeName;
	
	private String address;
	
	private String addressUsername;
	
	private String addressMobile;
	
	/**
	 * 设置：
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * 设置：项目ID
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目ID
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * 设置：支付状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：支付状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：原价格
	 */
	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}
	/**
	 * 获取：原价格
	 */
	public BigDecimal getCostprice() {
		return costprice;
	}
	/**
	 * 设置：商品价格
	 */
	public void setGoodsprice(BigDecimal goodsprice) {
		this.goodsprice = goodsprice;
	}
	/**
	 * 获取：商品价格
	 */
	public BigDecimal getGoodsprice() {
		return goodsprice;
	}
	/**
	 * 设置：打折抵扣
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	/**
	 * 获取：打折抵扣
	 */
	public BigDecimal getDiscount() {
		return discount;
	}
	/**
	 * 设置：体验金抵扣
	 */
	public void setDiscounttestmoney(BigDecimal discounttestmoney) {
		this.discounttestmoney = discounttestmoney;
	}
	/**
	 * 获取：体验金抵扣
	 */
	public BigDecimal getDiscounttestmoney() {
		return discounttestmoney;
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
	/**
	 * 设置：结束时间
	 */
	public void setFintime(String fintime) {
		this.fintime = fintime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getFintime() {
		return fintime;
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
	 * 设置：支付状态
	 */
	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}
	/**
	 * 获取：支付状态
	 */
	public String getTradeState() {
		return tradeState;
	}
	/**
	 * 设置：订单类型（shop表示商城，recharge表示充值，project表示购买专家课程,reward表示签到奖励,transfer表示转账）
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：订单类型（shop表示商城，recharge表示充值，project表示购买专家课程,reward表示签到奖励,transfer表示转账）
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：专家名称
	 */
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
	/**
	 * 获取：专家名称
	 */
	public String getExpertName() {
		return expertName;
	}
	/**
	 * 设置：订单号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}
	/**
	 * 设置：评分
	 */
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	/**
	 * 获取：评分
	 */
	public BigDecimal getScore() {
		return score;
	}
	/**
	 * 设置：评价
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：评价
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置：评价时间
	 */
	public void setScoreTime(String scoreTime) {
		this.scoreTime = scoreTime;
	}
	/**
	 * 获取：评价时间
	 */
	public String getScoreTime() {
		return scoreTime;
	}
	/**
	 * 设置：支付方式
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付方式
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置：快递单号
	 */
	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}
	/**
	 * 获取：快递单号
	 */
	public String getExpressId() {
		return expressId;
	}
	/**
	 * 设置：快递公司
	 */
	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}
	/**
	 * 获取：快递公司
	 */
	public String getExpressCompany() {
		return expressCompany;
	}
	/**
	 * 设置：地址
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * 获取：地址
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：邮费
	 */
	public void setExpressFee(BigDecimal expressFee) {
		this.expressFee = expressFee;
	}
	/**
	 * 获取：邮费
	 */
	public BigDecimal getExpressFee() {
		return expressFee;
	}
	/**
	 * 设置：购物车id
	 */
	public void setCartIds(String cartIds) {
		this.cartIds = cartIds;
	}
	/**
	 * 获取：购物车id
	 */
	public String getCartIds() {
		return cartIds;
	}
	/**
	 * 设置：交易类型-收入支出
	 */
	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * 获取：交易类型-收入支出
	 */
	public Integer getTransactionType() {
		return transactionType;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressUsername() {
		return addressUsername;
	}
	public void setAddressUsername(String addressUsername) {
		this.addressUsername = addressUsername;
	}
	public String getAddressMobile() {
		return addressMobile;
	}
	public void setAddressMobile(String addressMobile) {
		this.addressMobile = addressMobile;
	}
	
	
}
