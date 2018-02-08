package com.ms1491.modules.college.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.college.entity.UserCourseEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 用户-课程关系
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
 @Mapper
public interface UserCourseDao extends BaseDao<UserCourseEntity> {
	 int finishBatch(Object[] id);
}
