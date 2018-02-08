package com.ms1491.modules.college.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ms1491.modules.api.utils.Condition;




/**
 * 学院
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
public class CollegeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String collegeId;
	//color
	private String color;
	//学院标题
	private String title;
	//学院介绍
	private String collegeIntroduction;
	//讲师介绍
	private String leaderIntroduction;
	//课程体系
	private String courseSystem;
	//创建时间
	private Date createTime;
	//筛选条件 时间 地点 讲师
	private List<Condition> conditions;

	/**
	 * 设置：主键id
	 */
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	/**
	 * 获取：主键id
	 */
	public String getCollegeId() {
		return collegeId;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 设置：学院标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：学院标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：学院介绍
	 */
	public void setCollegeIntroduction(String collegeIntroduction) {
		this.collegeIntroduction = collegeIntroduction;
	}
	/**
	 * 获取：学院介绍
	 */
	public String getCollegeIntroduction() {
		return collegeIntroduction;
	}
	/**
	 * 设置：讲师介绍
	 */
	public void setLeaderIntroduction(String leaderIntroduction) {
		this.leaderIntroduction = leaderIntroduction;
	}
	/**
	 * 获取：讲师介绍
	 */
	public String getLeaderIntroduction() {
		return leaderIntroduction;
	}
	/**
	 * 设置：课程体系
	 */
	public void setCourseSystem(String courseSystem) {
		this.courseSystem = courseSystem;
	}
	/**
	 * 获取：课程体系
	 */
	public String getCourseSystem() {
		return courseSystem;
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
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	
}
