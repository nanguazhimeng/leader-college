package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.OrdergoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public interface OrdergoodsService {
	
	OrdergoodsEntity queryObject(String ordergoodsId);
	
	List<OrdergoodsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrdergoodsEntity ordergoods);
	
	void update(OrdergoodsEntity ordergoods);
	
	void delete(String ordergoodsId);
	
	void deleteBatch(String[] ordergoodsIds);
}
