package com.ms1491.modules.appuser.service;

import com.ms1491.modules.appuser.entity.RelationshipEntity;

import java.util.List;
import java.util.Map;

/**
 * 上下级关系表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
public interface RelationshipService {
	
	RelationshipEntity queryObject(String relationshipId);
	
	List<RelationshipEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RelationshipEntity relationship);
	
	void update(RelationshipEntity relationship);
	
	void delete(String relationshipId);
	
	void deleteBatch(String[] relationshipIds);
}
