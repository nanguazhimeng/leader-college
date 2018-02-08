package com.ms1491.modules.college.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.common.validator.group.UpdateGroup;



/**
 * 学院课程

 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
public class CourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String courseId;
	//学院id
	@NotNull(message="所属学院不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String collegeId;
	
	private String collegeName;
	//课程名称
	@NotNull(message="课程名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	@NotNull(message="开课时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String startTime;
	//地点
	private String place;
	//讲师
	private String leaderName;
	//课程细节
	private String courseIntroduction;
	//状态
	private Integer status;
	//报名资格
	private Integer signupLimit;
	//报名资格内容
	private String signupLimitContent;
	//封面图片
	private String coverImg;
	//精彩回顾
	private String contentReview;
	//视频回顾
	private String videoReview;
	//创建时间
	private Date createTime;
	//是否报名
	private int hasSignup;
	
	private int signupNumber;
	/**
	 * 设置：主键
id
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：主键
id
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * 设置：学院id
	 */
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	/**
	 * 获取：学院id
	 */
	public String getCollegeId() {
		return collegeId;
	}
	/**
	 * 设置：课程名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：课程名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：地点
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * 获取：地点
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * 设置：讲师
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	/**
	 * 获取：讲师
	 */
	public String getLeaderName() {
		return leaderName;
	}
	/**
	 * 设置：课程细节
	 */
	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}
	/**
	 * 获取：课程细节
	 */
	public String getCourseIntroduction() {
		return courseIntroduction;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：报名资格
	 */
	public void setSignupLimit(Integer signupLimit) {
		this.signupLimit = signupLimit;
	}
	/**
	 * 获取：报名资格
	 */
	public Integer getSignupLimit() {
		return signupLimit;
	}
	/**
	 * 设置：封面图片
	 */
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	/**
	 * 获取：封面图片
	 */
	public String getCoverImg() {
		return coverImg;
	}
	/**
	 * 设置：精彩回顾
	 */
	public void setContentReview(String contentReview) {
		this.contentReview = contentReview;
	}
	/**
	 * 获取：精彩回顾
	 */
	public String getContentReview() {
		return contentReview;
	}
	/**
	 * 设置：视频回顾
	 */
	public void setVideoReview(String videoReview) {
		this.videoReview = videoReview;
	}
	/**
	 * 获取：视频回顾
	 */
	public String getVideoReview() {
		return videoReview;
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
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getSignupLimitContent() {
		return signupLimitContent;
	}
	public void setSignupLimitContent(String signupLimitContent) {
		this.signupLimitContent = signupLimitContent;
	}
	public int getHasSignup() {
		return hasSignup;
	}
	public void setHasSignup(int hasSignup) {
		this.hasSignup = hasSignup;
	}
	public int getSignupNumber() {
		return signupNumber;
	}
	public void setSignupNumber(int signupNumber) {
		this.signupNumber = signupNumber;
	}
	
}
