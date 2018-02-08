package com.ms1491.modules.college.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.college.entity.CollegeEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 学院
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
 @Mapper
public interface CollegeDao extends BaseDao<CollegeEntity> {
	
}
