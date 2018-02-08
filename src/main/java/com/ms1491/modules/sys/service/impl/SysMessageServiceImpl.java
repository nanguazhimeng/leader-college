package com.ms1491.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.sys.dao.SysMessageDao;
import com.ms1491.modules.sys.entity.SysMessageEntity;
import com.ms1491.modules.sys.service.SysMessageService;



@Service("sysMessageService")
public class SysMessageServiceImpl implements SysMessageService {
	@Autowired
	private SysMessageDao sysMessageDao;
	
	@Override
	public SysMessageEntity queryObject(Integer id){
		return sysMessageDao.queryObject(id);
	}
	
	@Override
	public List<SysMessageEntity> queryList(Map<String, Object> map){
		return sysMessageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysMessageDao.queryTotal(map);
	}
	
	@Override
	public void save(SysMessageEntity sysMessage){
		sysMessageDao.save(sysMessage);
	}
	
	@Override
	public void update(SysMessageEntity sysMessage){
		sysMessageDao.update(sysMessage);
	}
	
	@Override
	public void delete(Integer id){
		sysMessageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysMessageDao.deleteBatch(ids);
	}

	@Override
	public void publishBatch(Integer[] ids) {
		sysMessageDao.publishBatch(ids);
	}
	
}
