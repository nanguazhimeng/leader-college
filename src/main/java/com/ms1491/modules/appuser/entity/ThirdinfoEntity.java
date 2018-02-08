package com.ms1491.modules.appuser.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 第三方账户信息
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
public class ThirdinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String thirdUserId;
	//用户id
	private String uid;
	//客户端（qq,wechat,weibo）
	private String client;
	//昵称
	private String thirdNickname;
	//头像
	private String thirdAvatar;
	//OPENID
	private String openid;
	//性别
	private String gender;
	//
	private String livingPlace;
	//
	private String birthPlace;
	//
	private String birthDay;

	/**
	 * 设置：
	 */
	public void setThirdUserId(String thirdUserId) {
		this.thirdUserId = thirdUserId;
	}
	/**
	 * 获取：
	 */
	public String getThirdUserId() {
		return thirdUserId;
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
	 * 设置：客户端（qq,wechat,weibo）
	 */
	public void setClient(String client) {
		this.client = client;
	}
	/**
	 * 获取：客户端（qq,wechat,weibo）
	 */
	public String getClient() {
		return client;
	}
	/**
	 * 设置：昵称
	 */
	public void setThirdNickname(String thirdNickname) {
		this.thirdNickname = thirdNickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getThirdNickname() {
		return thirdNickname;
	}
	/**
	 * 设置：头像
	 */
	public void setThirdAvatar(String thirdAvatar) {
		this.thirdAvatar = thirdAvatar;
	}
	/**
	 * 获取：头像
	 */
	public String getThirdAvatar() {
		return thirdAvatar;
	}
	/**
	 * 设置：OPENID
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：OPENID
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：性别
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：
	 */
	public void setLivingPlace(String livingPlace) {
		this.livingPlace = livingPlace;
	}
	/**
	 * 获取：
	 */
	public String getLivingPlace() {
		return livingPlace;
	}
	/**
	 * 设置：
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	/**
	 * 获取：
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	/**
	 * 设置：
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * 获取：
	 */
	public String getBirthDay() {
		return birthDay;
	}
}
