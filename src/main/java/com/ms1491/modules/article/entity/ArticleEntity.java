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
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String articleId;
	//主题id
	@NotNull(message="主题不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String themeId;
	
	private String themeName;
	//标题
	@NotNull(message="标题不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String title;
	//类型：1（url链接），2（音频），3（视频）
	@NotNull(message="类型不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer contentType;
	//封面图片
	@NotNull(message="封面图片不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String coverImg;
	//链接url（文本，音频，视频）
	@NotNull(message="url不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String url;
	//创建时间
	private Date createTime;
	//排序
	private Integer playOrder;
	//时长/阅读时长
	@NotNull(message="时长/阅读时长不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String duration;

	/**
	 * 设置：
	 */
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	/**
	 * 获取：
	 */
	public String getArticleId() {
		return articleId;
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
	 * 设置：链接url（文本，音频，视频）
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接url（文本，音频，视频）
	 */
	public String getUrl() {
		return url;
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
	/**
	 * 设置：时长/阅读时长
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * 获取：时长/阅读时长
	 */
	public String getDuration() {
		return duration;
	}
	public String getThemeId() {
		return themeId;
	}
	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
}
