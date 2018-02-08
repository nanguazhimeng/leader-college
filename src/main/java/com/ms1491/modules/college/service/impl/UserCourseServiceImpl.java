package com.ms1491.modules.college.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.college.dao.UserCourseDao;
import com.ms1491.modules.college.entity.UserCourseEntity;
import com.ms1491.modules.college.service.UserCourseService;



@Service("userCourseService")
public class UserCourseServiceImpl implements UserCourseService {
	@Autowired
	private UserCourseDao userCourseDao;
	
	@Override
	public UserCourseEntity queryObject(String id){
		return userCourseDao.queryObject(id);
	}
	
	@Override
	public List<UserCourseEntity> queryList(Map<String, Object> map){
		return userCourseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userCourseDao.queryTotal(map);
	}
	
	@Override
	public void save(UserCourseEntity userCourse){
		userCourseDao.save(userCourse);
	}
	
	@Override
	public void update(UserCourseEntity userCourse){
		userCourseDao.update(userCourse);
	}
	
	@Override
	public void delete(String id){
		userCourseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		userCourseDao.deleteBatch(ids);
	}

	@Override
	public void finishBatch(String[] ids) {
		userCourseDao.finishBatch(ids);
	}
	
}
