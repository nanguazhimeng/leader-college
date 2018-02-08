package com.ms1491.modules.appuser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.appuser.dao.ThirdinfoDao;
import com.ms1491.modules.appuser.entity.ThirdinfoEntity;
import com.ms1491.modules.appuser.service.ThirdinfoService;



@Service("thirdinfoService")
public class ThirdinfoServiceImpl implements ThirdinfoService {
	@Autowired
	private ThirdinfoDao thirdinfoDao;
	
	@Override
	public ThirdinfoEntity queryObject(String thirdUserId){
		return thirdinfoDao.queryObject(thirdUserId);
	}
	
	@Override
	public List<ThirdinfoEntity> queryList(Map<String, Object> map){
		return thirdinfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return thirdinfoDao.queryTotal(map);
	}
	
	@Override
	public void save(ThirdinfoEntity thirdinfo){
		thirdinfoDao.save(thirdinfo);
	}
	
	@Override
	public void update(ThirdinfoEntity thirdinfo){
		thirdinfoDao.update(thirdinfo);
	}
	
	@Override
	public void delete(String thirdUserId){
		thirdinfoDao.delete(thirdUserId);
	}
	
	@Override
	public void deleteBatch(String[] thirdUserIds){
		thirdinfoDao.deleteBatch(thirdUserIds);
	}
	
}
