package com.ms1491.modules.appuser.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * app用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
public class AppUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String userId;
	//
	private String username;
	//
	private String phone;
	//
	private String password;
	//
	private String roleId;
	//1正常 0禁用 2在线
	private String status;
	//头像
	private String avatar;
	//性别（男Y女X）
	private String gender;
	//生日
	private String birthDay;
	//出生地点
	private String birthPlace;
	//现居地
	private String livingPlace;
	//账户余额
	private BigDecimal accountMoney;
	//体验金
	private BigDecimal testMoney;
	//融云token
	private String rongToken;
	//
	private String startTime;
	//
	private String email;
	//简介
	private String introduction;
	//擅长了领域
	private String honor;
	//
	private String tag;
	//
	private String videoUrl;
	//
	private String accessToken;
	//我的专属码
	private String exclusiveCode;
	//二维码
	private String twoDimensionCode;
	//是否删除
	private Integer isDelete;
	//上级id（接受上级id）
	private String pid;
	//
	private String lifeCode;
	//
	private String lifeDetail;
	//展示商城所属店铺
	private String pstoreId;
	//
	private String puid;
	

	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置：1正常 0禁用 2在线
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：1正常 0禁用 2在线
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：性别（男Y女X）
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别（男Y女X）
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：生日
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * 获取：生日
	 */
	public String getBirthDay() {
		return birthDay;
	}
	/**
	 * 设置：出生地点
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	/**
	 * 获取：出生地点
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	/**
	 * 设置：现居地
	 */
	public void setLivingPlace(String livingPlace) {
		this.livingPlace = livingPlace;
	}
	/**
	 * 获取：现居地
	 */
	public String getLivingPlace() {
		return livingPlace;
	}
	/**
	 * 设置：账户余额
	 */
	public void setAccountMoney(BigDecimal accountMoney) {
		this.accountMoney = accountMoney;
	}
	/**
	 * 获取：账户余额
	 */
	public BigDecimal getAccountMoney() {
		return accountMoney;
	}
	/**
	 * 设置：体验金
	 */
	public void setTestMoney(BigDecimal testMoney) {
		this.testMoney = testMoney;
	}
	/**
	 * 获取：体验金
	 */
	public BigDecimal getTestMoney() {
		return testMoney;
	}
	/**
	 * 设置：融云token
	 */
	public void setRongToken(String rongToken) {
		this.rongToken = rongToken;
	}
	/**
	 * 获取：融云token
	 */
	public String getRongToken() {
		return rongToken;
	}
	/**
	 * 设置：
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
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
	 * 设置：擅长了领域
	 */
	public void setHonor(String honor) {
		this.honor = honor;
	}
	/**
	 * 获取：擅长了领域
	 */
	public String getHonor() {
		return honor;
	}
	/**
	 * 设置：
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * 获取：
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * 设置：
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	/**
	 * 获取：
	 */
	public String getVideoUrl() {
		return videoUrl;
	}
	/**
	 * 设置：
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * 获取：
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * 设置：我的专属码
	 */
	public void setExclusiveCode(String exclusiveCode) {
		this.exclusiveCode = exclusiveCode;
	}
	/**
	 * 获取：我的专属码
	 */
	public String getExclusiveCode() {
		return exclusiveCode;
	}
	/**
	 * 设置：二维码
	 */
	public void setTwoDimensionCode(String twoDimensionCode) {
		this.twoDimensionCode = twoDimensionCode;
	}
	/**
	 * 获取：二维码
	 */
	public String getTwoDimensionCode() {
		return twoDimensionCode;
	}
	/**
	 * 设置：是否删除
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：上级id（接受上级id）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：上级id（接受上级id）
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setLifeCode(String lifeCode) {
		this.lifeCode = lifeCode;
	}
	/**
	 * 获取：
	 */
	public String getLifeCode() {
		return lifeCode;
	}
	/**
	 * 设置：
	 */
	public void setLifeDetail(String lifeDetail) {
		this.lifeDetail = lifeDetail;
	}
	/**
	 * 获取：
	 */
	public String getLifeDetail() {
		return lifeDetail;
	}
	public String getPstoreId() {
		return pstoreId;
	}
	public void setPstoreId(String pstoreId) {
		this.pstoreId = pstoreId;
	}
	public String getPuid() {
		return puid;
	}
	public void setPuid(String puid) {
		this.puid = puid;
	}
	
	
}
