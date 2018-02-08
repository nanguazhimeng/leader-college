package com.ms1491.modules.college.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.college.dao.CollegeDao;
import com.ms1491.modules.college.entity.CollegeEntity;
import com.ms1491.modules.college.service.CollegeService;



@Service("collegeService")
public class CollegeServiceImpl implements CollegeService {
	@Autowired
	private CollegeDao collegeDao;
	
	@Override
	public CollegeEntity queryObject(String collegeId){
		return collegeDao.queryObject(collegeId);
	}
	
	@Override
	public List<CollegeEntity> queryList(Map<String, Object> map){
		return collegeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return collegeDao.queryTotal(map);
	}
	
	@Override
	public void save(CollegeEntity college){
		collegeDao.save(college);
	}
	
	@Override
	public void update(CollegeEntity college){
		collegeDao.update(college);
	}
	
	@Override
	public void delete(String collegeId){
		collegeDao.delete(collegeId);
	}
	
	@Override
	public void deleteBatch(String[] collegeIds){
		collegeDao.deleteBatch(collegeIds);
	}
	
}
