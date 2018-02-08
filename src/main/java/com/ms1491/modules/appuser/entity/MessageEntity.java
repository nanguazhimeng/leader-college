package com.ms1491.modules.appuser.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 消息通知
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户id
	private String uid;
	//标题
	private String title;
	//内容
	private String content;
	//是否已读
	private boolean isRead;
	//创建时间
	private Date createTime;
	//alia
	private String alia;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：是否已读
	 */
	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}
	/**
	 * 获取：是否已读
	 */
	public boolean getIsRead() {
		return isRead;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAlia() {
		return alia;
	}
	public void setAlia(String alia) {
		this.alia = alia;
	}
	
}
