package com.ms1491.modules.appuser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.appuser.dao.RelationshipDao;
import com.ms1491.modules.appuser.entity.RelationshipEntity;
import com.ms1491.modules.appuser.service.RelationshipService;



@Service("relationshipService")
public class RelationshipServiceImpl implements RelationshipService {
	@Autowired
	private RelationshipDao relationshipDao;
	
	@Override
	public RelationshipEntity queryObject(String relationshipId){
		return relationshipDao.queryObject(relationshipId);
	}
	
	@Override
	public List<RelationshipEntity> queryList(Map<String, Object> map){
		return relationshipDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return relationshipDao.queryTotal(map);
	}
	
	@Override
	public void save(RelationshipEntity relationship){
		relationshipDao.save(relationship);
	}
	
	@Override
	public void update(RelationshipEntity relationship){
		relationshipDao.update(relationship);
	}
	
	@Override
	public void delete(String relationshipId){
		relationshipDao.delete(relationshipId);
	}
	
	@Override
	public void deleteBatch(String[] relationshipIds){
		relationshipDao.deleteBatch(relationshipIds);
	}
	
}
