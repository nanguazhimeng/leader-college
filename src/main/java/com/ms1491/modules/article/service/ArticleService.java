package com.ms1491.modules.article.service;

import com.ms1491.modules.article.entity.ArticleEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-12-20 13:46:28
 */
public interface ArticleService {
	
	ArticleEntity queryObject(String articleId);
	
	List<ArticleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ArticleEntity article);
	
	void update(ArticleEntity article);
	
	void delete(String articleId);
	
	void deleteBatch(String[] articleIds);
}
