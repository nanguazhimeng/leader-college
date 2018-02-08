package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.CommissionlogEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-10-10 15:06:31
 */
public interface CommissionlogService {
	
	CommissionlogEntity queryObject(String commissionlogId);
	
	List<CommissionlogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CommissionlogEntity commissionlog);
	
	void update(CommissionlogEntity commissionlog);
	
	void delete(String commissionlogId);
	
	void deleteBatch(String[] commissionlogIds);
}
