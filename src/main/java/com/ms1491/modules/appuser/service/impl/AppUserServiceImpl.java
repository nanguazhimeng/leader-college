package com.ms1491.modules.appuser.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1491.modules.appuser.dao.AppUserDao;
import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.appuser.service.AppUserService;



@Service("appUserService")
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserDao appUserDao;
	
	@Override
	public AppUserEntity queryObject(String userId){
		return appUserDao.queryObject(userId);
	}
	
	@Override
	public List<AppUserEntity> queryList(Map<String, Object> map){
		return appUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appUserDao.queryTotal(map);
	}
	
	@Override
	public void save(AppUserEntity user){
		appUserDao.save(user);
	}
	
	@Override
	public void update(AppUserEntity user){
		appUserDao.update(user);
	}
	
	@Override
	public void delete(String userId){
		appUserDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(String[] userIds){
		appUserDao.deleteBatch(userIds);
	}
	
}
