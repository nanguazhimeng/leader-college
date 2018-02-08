package com.ms1491.modules.article.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.common.validator.group.UpdateGroup;



/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-12-20 13:46:28
 */
public class ThemeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主题id
	private String themeId;
	//主题名称
	@NotNull(message="主题名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	
	private Integer type;
	
	private String parentId;
	
	private Integer contentType; 
	//图标
	private String icon;
	//背景颜色
	private String color;
	//创建时间
	private Date createTime;
	//排序
	private Integer playOrder;
	
	private String parentName;
	/**
	 * ztree属性
	 */
	private Boolean open;
	private List<?> list;
	/**
	 * 设置：主题id
	 */
	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}
	/**
	 * 获取：主题id
	 */
	public String getThemeId() {
		return themeId;
	}
	/**
	 * 设置：主题名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：主题名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：背景颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 获取：背景颜色
	 */
	public String getColor() {
		return color;
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
	/**
	 * 设置：排序
	 */
	public void setPlayOrder(Integer playOrder) {
		this.playOrder = playOrder;
	}
	/**
	 * 获取：排序
	 */
	public Integer getPlayOrder() {
		return playOrder;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
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
