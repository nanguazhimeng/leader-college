package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.util.List;



/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-29 14:19:52
 */
public class GoodscategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String goodscategoryId;
	//分类名称
	private String name;
	//分类图片
	private String icon;
	//分类描述
	private String description;
	//排序
	private Integer displayorder;
	//
	private String pid;
	
	private String parentName;
	//
	private Integer level;
	//是否显示
	private Integer enabled;
	//首页推荐
	private Integer ishome;
	/**
	 * ztree属性
	 */
	private Boolean open;
	private List<?> list;
	/**
	 * 设置：
	 */
	public void setGoodscategoryId(String goodscategoryId) {
		this.goodscategoryId = goodscategoryId;
	}
	/**
	 * 获取：
	 */
	public String getGoodscategoryId() {
		return goodscategoryId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：分类名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：分类图片
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：分类图片
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：分类描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：分类描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：排序
	 */
	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}
	/**
	 * 获取：排序
	 */
	public Integer getDisplayorder() {
		return displayorder;
	}
	/**
	 * 设置：
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：是否显示
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	/**
	 * 获取：是否显示
	 */
	public Integer getEnabled() {
		return enabled;
	}
	/**
	 * 设置：首页推荐
	 */
	public void setIshome(Integer ishome) {
		this.ishome = ishome;
	}
	/**
	 * 获取：首页推荐
	 */
	public Integer getIshome() {
		return ishome;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
