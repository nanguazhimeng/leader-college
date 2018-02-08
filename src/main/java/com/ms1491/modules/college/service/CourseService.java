package com.ms1491.modules.college.service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.college.entity.CourseEntity;

/**
 * 学院课程

 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
public interface CourseService {
	
	CourseEntity queryObject(String courseId);
	
	List<CourseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CourseEntity course);
	
	void update(CourseEntity course);
	
	void delete(String courseId);
	
	void deleteBatch(String[] courseIds);
	
	CourseEntity signup(String uid,String roleId,String courseId,String realname,String mobile,String weixinAccount);
	
	void finishBatch(String[] courseIds);
}
