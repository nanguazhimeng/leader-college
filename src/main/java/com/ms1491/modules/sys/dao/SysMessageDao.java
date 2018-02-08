package com.ms1491.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.sys.entity.SysMessageEntity;
/**
 * 系统消息
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-22 12:11:32
 */
 @Mapper
public interface SysMessageDao extends BaseDao<SysMessageEntity> {
	 int publishBatch(Object[] id);
}
