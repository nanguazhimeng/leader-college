package com.ms1491.modules.shop.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.common.validator.group.UpdateGroup;



/**
 * 模板管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public class TemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//模板id
	private String templateId;
	
	//模板名称
	@NotNull(message="模板名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	//模板标识
	@NotNull(message="模板标识不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String code;
	
	//模型
	@NotNull(message="图片不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String model;
	//图片
	@NotNull(message="图片不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String picture;
	private Integer delete;
	private Integer status;
	
	private String ad;
	/**
	 * 设置：模板id
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板id
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：模板名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：模板名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：模型
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：模型
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDelete() {
		return delete;
	}
	public void setDelete(Integer delete) {
		this.delete = delete;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
}
