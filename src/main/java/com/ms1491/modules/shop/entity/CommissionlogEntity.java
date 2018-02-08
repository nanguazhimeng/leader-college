package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-10-10 15:06:31
 */
public class CommissionlogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String commissionlogId;
	//当前佣金
	private BigDecimal currentCommission;
	//佣金增减
	private BigDecimal addCommision;
	//个人业绩增减
	private BigDecimal addIndividual;
	//团队业绩增减
	private BigDecimal addTeam;
	//说明
	private String remark;
	//用户id
	private String uid;
	//类型
	private Integer type;
	//创建时间
	private String createtime;
	//订单号
	private String outTradeNo;

	/**
	 * 设置：
	 */
	public void setCommissionlogId(String commissionlogId) {
		this.commissionlogId = commissionlogId;
	}
	/**
	 * 获取：
	 */
	public String getCommissionlogId() {
		return commissionlogId;
	}
	/**
	 * 设置：当前佣金
	 */
	public void setCurrentCommission(BigDecimal currentCommission) {
		this.currentCommission = currentCommission;
	}
	/**
	 * 获取：当前佣金
	 */
	public BigDecimal getCurrentCommission() {
		return currentCommission;
	}
	/**
	 * 设置：佣金增减
	 */
	public void setAddCommision(BigDecimal addCommision) {
		this.addCommision = addCommision;
	}
	/**
	 * 获取：佣金增减
	 */
	public BigDecimal getAddCommision() {
		return addCommision;
	}
	/**
	 * 设置：个人业绩增减
	 */
	public void setAddIndividual(BigDecimal addIndividual) {
		this.addIndividual = addIndividual;
	}
	/**
	 * 获取：个人业绩增减
	 */
	public BigDecimal getAddIndividual() {
		return addIndividual;
	}
	/**
	 * 设置：团队业绩增减
	 */
	public void setAddTeam(BigDecimal addTeam) {
		this.addTeam = addTeam;
	}
	/**
	 * 获取：团队业绩增减
	 */
	public BigDecimal getAddTeam() {
		return addTeam;
	}
	/**
	 * 设置：说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：说明
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreatetime() {
		return createtime;
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
}
