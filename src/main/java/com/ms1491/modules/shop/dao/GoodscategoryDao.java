package com.ms1491.modules.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.shop.entity.GoodscategoryEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-29 14:19:52
 */
 @Mapper
public interface GoodscategoryDao extends BaseDao<GoodscategoryEntity> {
		/**
		 * 根据父菜单，查询子菜单
		 * @param parentId 父菜单ID
		 */
		List<GoodscategoryEntity> queryListParentId(String pid);
}
