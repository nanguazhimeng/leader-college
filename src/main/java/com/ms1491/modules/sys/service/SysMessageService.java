package com.ms1491.modules.sys.service;

import com.ms1491.modules.sys.entity.SysMessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统消息
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-22 12:11:32
 */
public interface SysMessageService {
	
	SysMessageEntity queryObject(Integer id);
	
	List<SysMessageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysMessageEntity sysMessage);
	
	void update(SysMessageEntity sysMessage);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	void publishBatch(Integer[] ids);
}
