package com.ms1491.modules.college.service;

import com.ms1491.modules.college.entity.CollegeEntity;

import java.util.List;
import java.util.Map;

/**
 * 学院
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
public interface CollegeService {
	
	CollegeEntity queryObject(String collegeId);
	
	List<CollegeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CollegeEntity college);
	
	void update(CollegeEntity college);
	
	void delete(String collegeId);
	
	void deleteBatch(String[] collegeIds);
}
