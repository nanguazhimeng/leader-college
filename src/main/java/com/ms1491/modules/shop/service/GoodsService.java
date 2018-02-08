package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.GoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public interface GoodsService {
	
	GoodsEntity queryObject(String goodsId);
	
	List<GoodsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsEntity goods);
	
	void update(GoodsEntity goods);
	
	void delete(String goodsId);
	
	void deleteBatch(String[] goodsIds);
}
