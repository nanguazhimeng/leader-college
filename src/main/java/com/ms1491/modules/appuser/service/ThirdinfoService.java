package com.ms1491.modules.appuser.service;

import com.ms1491.modules.appuser.entity.ThirdinfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 第三方账户信息
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
public interface ThirdinfoService {
	
	ThirdinfoEntity queryObject(String thirdUserId);
	
	List<ThirdinfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ThirdinfoEntity thirdinfo);
	
	void update(ThirdinfoEntity thirdinfo);
	
	void delete(String thirdUserId);
	
	void deleteBatch(String[] thirdUserIds);
}
