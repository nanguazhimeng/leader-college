package com.ms1491.modules.article.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.article.entity.ArticleEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-12-20 13:46:28
 */
 @Mapper
public interface ArticleDao extends BaseDao<ArticleEntity> {
	
}
