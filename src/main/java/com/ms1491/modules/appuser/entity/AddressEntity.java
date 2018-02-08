package com.ms1491.modules.appuser.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户收获地址
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String addressId;
	//用户id
	private String uid;
	//姓名
	private String username;
	//手机号
	private String mobile;
	//详细地址
	private String address;
	//邮编
	private String zipcode;
	//省份
	private String province;
	//城市
	private String city;

	/**
	 * 设置：
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	/**
	 * 获取：
	 */
	public String getAddressId() {
		return addressId;
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
	 * 设置：姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：邮编
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
}
