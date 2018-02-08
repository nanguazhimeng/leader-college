package com.ms1491.modules.api.utils;

import java.util.List;

import com.ms1491.modules.shop.entity.StoreGoodsEntity;

public class GoodsListResponse {
	
	private List<Item> items;
	
	private List<StoreGoodsEntity> storeGoods;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<StoreGoodsEntity> getStoreGoods() {
		return storeGoods;
	}

	public void setStoreGoods(List<StoreGoodsEntity> storeGoods) {
		this.storeGoods = storeGoods;
	}


	
}
