package com.ms1491.modules.college.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户-课程关系
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
public class UserCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String id;
	//用户id
	private String uid;
	//课程id
	private String courseId;
	//真实姓名
	private String realname;
	//手机号
	private String mobile;
	//微信号
	private String weixinAccount;
	
	//状态
	private Integer status;
	//创建时间
	private Date createTime;
	
	private String name;
	private String startTime;
	private String place;
	private String leaderName;
	private String coverImg;
	
	/**
	 * 设置：主键id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public String getId() {
		return id;
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
	 * 设置：课程id
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程id
	 */
	public String getCourseId() {
		return courseId;
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
	 * 设置：微信号
	 */
	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}
	/**
	 * 获取：微信号
	 */
	public String getWeixinAccount() {
		return weixinAccount;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
