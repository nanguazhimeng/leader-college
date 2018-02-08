package com.ms1491.modules.appuser.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 上下级关系表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
public class RelationshipEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String relationshipId;
	//用户
	private String uid;
	//上级用户
	private String puid;
	//下级用户
	private String subuids;
	//个人业绩
	private BigDecimal individualPerformance;
	//团队业绩
	private BigDecimal teamPerformance;
	//总佣金
	private BigDecimal totalCommission;
	//未提佣金
	private BigDecimal commission;
	//奖金
	private BigDecimal prize;
	//个人消费
	private BigDecimal personal;
	//状态0未申请，2申请中，1商户
	private Integer status;
	//创建时间
	private String createTime;
	//真实姓名
	private String realname;
	//银行名称
	private String bankname;
	//银行卡号
	private String account;
	//审核时间
	private String checkTime;
	//粉丝量
	private Integer fans;
	//省代数量
	private Integer shengdaiNum;
	//身份证正面照
	private String idCardFace;
	//身份证反面照
	private String idCardBack;
	//手机号
	private String phone;
	//email
	private String email;
	//地址
	private String address;
	
	private String username;
	
	private String rolename;
	
	private String avatar;
	
	private String pname;
	
	private String mobile;
	
	

	/**
	 * 设置：
	 */
	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}
	/**
	 * 获取：
	 */
	public String getRelationshipId() {
		return relationshipId;
	}
	/**
	 * 设置：用户
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：上级用户
	 */
	public void setPuid(String puid) {
		this.puid = puid;
	}
	/**
	 * 获取：上级用户
	 */
	public String getPuid() {
		return puid;
	}
	/**
	 * 设置：下级用户
	 */
	public void setSubuids(String subuids) {
		this.subuids = subuids;
	}
	/**
	 * 获取：下级用户
	 */
	public String getSubuids() {
		return subuids;
	}
	/**
	 * 设置：个人业绩
	 */
	public void setIndividualPerformance(BigDecimal individualPerformance) {
		this.individualPerformance = individualPerformance;
	}
	/**
	 * 获取：个人业绩
	 */
	public BigDecimal getIndividualPerformance() {
		return individualPerformance;
	}
	/**
	 * 设置：团队业绩
	 */
	public void setTeamPerformance(BigDecimal teamPerformance) {
		this.teamPerformance = teamPerformance;
	}
	/**
	 * 获取：团队业绩
	 */
	public BigDecimal getTeamPerformance() {
		return teamPerformance;
	}
	/**
	 * 设置：总佣金
	 */
	public void setTotalCommission(BigDecimal totalCommission) {
		this.totalCommission = totalCommission;
	}
	/**
	 * 获取：总佣金
	 */
	public BigDecimal getTotalCommission() {
		return totalCommission;
	}
	/**
	 * 设置：未提佣金
	 */
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
	/**
	 * 获取：未提佣金
	 */
	public BigDecimal getCommission() {
		return commission;
	}
	/**
	 * 设置：奖金
	 */
	public void setPrize(BigDecimal prize) {
		this.prize = prize;
	}
	/**
	 * 获取：奖金
	 */
	public BigDecimal getPrize() {
		return prize;
	}
	/**
	 * 设置：个人消费
	 */
	public void setPersonal(BigDecimal personal) {
		this.personal = personal;
	}
	/**
	 * 获取：个人消费
	 */
	public BigDecimal getPersonal() {
		return personal;
	}
	/**
	 * 设置：状态0未申请，2申请中，1商户
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态0未申请，2申请中，1商户
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：银行名称
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	/**
	 * 获取：银行名称
	 */
	public String getBankname() {
		return bankname;
	}
	/**
	 * 设置：银行卡号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：银行卡号
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：审核时间
	 */
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	/**
	 * 获取：审核时间
	 */
	public String getCheckTime() {
		return checkTime;
	}
	/**
	 * 设置：粉丝量
	 */
	public void setFans(Integer fans) {
		this.fans = fans;
	}
	/**
	 * 获取：粉丝量
	 */
	public Integer getFans() {
		return fans;
	}
	/**
	 * 设置：省代数量
	 */
	public void setShengdaiNum(Integer shengdaiNum) {
		this.shengdaiNum = shengdaiNum;
	}
	/**
	 * 获取：省代数量
	 */
	public Integer getShengdaiNum() {
		return shengdaiNum;
	}
	/**
	 * 设置：身份证正面照
	 */
	public void setIdCardFace(String idCardFace) {
		this.idCardFace = idCardFace;
	}
	/**
	 * 获取：身份证正面照
	 */
	public String getIdCardFace() {
		return idCardFace;
	}
	/**
	 * 设置：身份证反面照
	 */
	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}
	/**
	 * 获取：身份证反面照
	 */
	public String getIdCardBack() {
		return idCardBack;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
