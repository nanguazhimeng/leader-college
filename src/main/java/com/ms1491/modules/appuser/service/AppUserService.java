package com.ms1491.modules.appuser.service;

import com.ms1491.modules.appuser.entity.AppUserEntity;

import java.util.List;
import java.util.Map;

/**
 * app用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
public interface AppUserService {
	
	AppUserEntity queryObject(String userId);
	
	List<AppUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppUserEntity user);
	
	void update(AppUserEntity user);
	
	void delete(String userId);
	
	void deleteBatch(String[] userIds);
}
