package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 商品管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String goodsId;
	//1为实体，2为虚拟
	private Integer type;
	//标题
	private String title;
	//描述
	private String description;
	//图片内容
	private String content;
	//文本内容
	private String contentTxt;
	//现价
	private BigDecimal marketprice;
	//成本
	private BigDecimal costprice;
	//原价
	private BigDecimal originalprice;
	//库存
	private Integer total;
	//0 拍下减库存 1 付款减库存 2 永久不减
	private Integer totalcnf;
	//创建时间
	private String createtime;
	//图片
	private String img;
	//图片详情
	private String imgDetail;
	//其他图片
	private String imgs;
	//单次最多购买
	private Integer maxbuy;
	//用户最多购买
	private Integer usermaxbuy;
	//新上
	private boolean isnew;
	//推荐
	private boolean isrecommand;
	//热卖 
	private boolean ishot;
	//促销  
	private boolean isdiscount;
	//限时卖
	private String istime;
	//包邮 
	private boolean issendfree;
	//是否上架
	private Integer isshow;
	//是否删除
	private boolean deleted;
	//评分
	private BigDecimal score;
	//已出售数
	private Integer sales;
	//分享标题
	private String shareTitle;
	//分享图标
	private String shareIcon;
	//分享描述
	private String shareDesc;
	//商品分类
	private String goodscategoryId;
	//商品分类
	private String goodscategoryName;
	//排序
	private Integer displayorder;
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentTxt() {
		return contentTxt;
	}
	public void setContentTxt(String contentTxt) {
		this.contentTxt = contentTxt;
	}
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	public BigDecimal getCostprice() {
		return costprice;
	}
	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}
	public BigDecimal getOriginalprice() {
		return originalprice;
	}
	public void setOriginalprice(BigDecimal originalprice) {
		this.originalprice = originalprice;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalcnf() {
		return totalcnf;
	}
	public void setTotalcnf(Integer totalcnf) {
		this.totalcnf = totalcnf;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getImgDetail() {
		return imgDetail;
	}
	public void setImgDetail(String imgDetail) {
		this.imgDetail = imgDetail;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public Integer getMaxbuy() {
		return maxbuy;
	}
	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}
	public Integer getUsermaxbuy() {
		return usermaxbuy;
	}
	public void setUsermaxbuy(Integer usermaxbuy) {
		this.usermaxbuy = usermaxbuy;
	}
	public boolean isIsnew() {
		return isnew;
	}
	public void setIsnew(boolean isnew) {
		this.isnew = isnew;
	}
	public boolean isIsrecommand() {
		return isrecommand;
	}
	public void setIsrecommand(boolean isrecommand) {
		this.isrecommand = isrecommand;
	}
	public boolean isIshot() {
		return ishot;
	}
	public void setIshot(boolean ishot) {
		this.ishot = ishot;
	}
	public boolean isIsdiscount() {
		return isdiscount;
	}
	public void setIsdiscount(boolean isdiscount) {
		this.isdiscount = isdiscount;
	}
	public String getIstime() {
		return istime;
	}
	public void setIstime(String istime) {
		this.istime = istime;
	}
	public boolean isIssendfree() {
		return issendfree;
	}
	public void setIssendfree(boolean issendfree) {
		this.issendfree = issendfree;
	}

	public Integer getIsshow() {
		return isshow;
	}
	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public String getShareTitle() {
		return shareTitle;
	}
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	public String getShareIcon() {
		return shareIcon;
	}
	public void setShareIcon(String shareIcon) {
		this.shareIcon = shareIcon;
	}
	public String getShareDesc() {
		return shareDesc;
	}
	public void setShareDesc(String shareDesc) {
		this.shareDesc = shareDesc;
	}
	public String getGoodscategoryId() {
		return goodscategoryId;
	}
	public void setGoodscategoryId(String goodscategoryId) {
		this.goodscategoryId = goodscategoryId;
	}
	public String getGoodscategoryName() {
		return goodscategoryName;
	}
	public void setGoodscategoryName(String goodscategoryName) {
		this.goodscategoryName = goodscategoryName;
	}
	public Integer getDisplayorder() {
		return displayorder;
	}
	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}
	
	
}
