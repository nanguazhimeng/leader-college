package com.ms1491.modules.appuser.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.sys.dao.BaseDao;

/**
 * app用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
@Mapper
public interface AppUserDao extends BaseDao<AppUserEntity> {
	
}
