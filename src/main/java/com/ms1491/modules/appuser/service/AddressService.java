package com.ms1491.modules.appuser.service;

import com.ms1491.modules.appuser.entity.AddressEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户收获地址
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
public interface AddressService {
	
	AddressEntity queryObject(String addressId);
	
	List<AddressEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AddressEntity address);
	
	void update(AddressEntity address);
	
	void delete(String addressId);
	
	void deleteBatch(String[] addressIds);
}
