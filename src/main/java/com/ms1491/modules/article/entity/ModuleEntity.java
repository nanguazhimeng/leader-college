package com.ms1491.modules.article.entity;

import java.io.Serializable;
import java.util.Date;

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
public class ModuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String moduleId;
	//主题id
	@NotNull(message="主题不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String themeId;
	//模块名称
	@NotNull(message="模块名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	//类型：1（url链接），2（音频），3（视频）
	@NotNull(message="类型不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer type;
	//创建时间
	private Date createTime;
	//排序
	private Integer playOrder;
	
	private String theme;

	/**
	 * 设置：
	 */
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	/**
	 * 获取：
	 */
	public String getModuleId() {
		return moduleId;
	}
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
	 * 设置：模块名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：模块名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：类型：1（url链接），2（音频），3（视频）
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型：1（url链接），2（音频），3（视频）
	 */
	public Integer getType() {
		return type;
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
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
}
