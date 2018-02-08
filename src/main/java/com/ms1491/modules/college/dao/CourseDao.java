package com.ms1491.modules.college.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.college.entity.CourseEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 学院课程

 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
 @Mapper
public interface CourseDao extends BaseDao<CourseEntity> {
	 CourseEntity queryObjectByUidAndCourseId(Map<String, Object> map);
	 
	 int finishBatch(Object[] id);
}
