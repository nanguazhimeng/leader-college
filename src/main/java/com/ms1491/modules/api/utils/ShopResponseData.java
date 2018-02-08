package com.ms1491.modules.api.utils;

import java.util.List;

public class ShopResponseData {

	private String storeId;
	//图标
	private String icon;
	//名称
	private String name;
	//简介
	private String introduction;
	//店铺模板
	private String templateCode;
	//全部商品个数
	private int total = 0;
	//上新个数
	private int newTotal = 0;
	
	private List<GoodscategoryResponse> goodscategoryList;
	
}
