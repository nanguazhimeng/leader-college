package com.ms1491.modules.shop.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.shop.entity.StoreEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 店铺管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
 @Mapper
public interface StoreDao extends BaseDao<StoreEntity> {
	 StoreEntity queryObjectByUid(String uid);
}
