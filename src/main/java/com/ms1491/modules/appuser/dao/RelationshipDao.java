package com.ms1491.modules.appuser.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.appuser.entity.RelationshipEntity;
import com.ms1491.modules.sys.dao.BaseDao;

/**
 * 上下级关系表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
@Mapper
public interface RelationshipDao extends BaseDao<RelationshipEntity> {
	
}
