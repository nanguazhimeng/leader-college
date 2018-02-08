package com.ms1491.modules.shop.service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.api.entity.StoreOrderEntity;
import com.ms1491.modules.shop.entity.OrderEntity;

/**
 * 订单管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public interface OrderService {
	
	OrderEntity queryObject(String orderId);
	
	List<OrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderEntity order);
	
	void update(OrderEntity order);
	
	void delete(String orderId);
	
	void deleteBatch(String[] orderIds);
	
	List<StoreOrderEntity> queryStoreOrderList(Map<String, Object> map);
}
