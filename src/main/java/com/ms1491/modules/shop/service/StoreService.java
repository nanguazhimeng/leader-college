package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.StoreEntity;

import java.util.List;
import java.util.Map;

/**
 * 店铺管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public interface StoreService {
	
	StoreEntity queryObject(String storeId);
	
	List<StoreEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StoreEntity store);
	
	void update(StoreEntity store);
	
	void delete(String storeId);
	
	void deleteBatch(String[] storeIds);
	
	StoreEntity queryObjectByUid(String uid);
	
}
