package com.ms1491.modules.article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.article.entity.ThemeEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-12-20 13:46:28
 */
 @Mapper
public interface ThemeDao extends BaseDao<ThemeEntity> {
		/**
		 * 根据父菜单，查询子菜单
		 * @param parentId 父菜单ID
		 */
		List<ThemeEntity> queryListParentId(String parentId);
}
