package com.ms1491.modules.college.service;

import com.ms1491.modules.college.entity.UserCourseEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户-课程关系
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
public interface UserCourseService {
	
	UserCourseEntity queryObject(String id);
	
	List<UserCourseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserCourseEntity userCourse);
	
	void update(UserCourseEntity userCourse);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	void finishBatch(String[] ids);
}
