package com.ms1491.modules.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.article.dao.ArticleDao;
import com.ms1491.modules.article.entity.ArticleEntity;
import com.ms1491.modules.article.service.ArticleService;



@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public ArticleEntity queryObject(String articleId){
		return articleDao.queryObject(articleId);
	}
	
	@Override
	public List<ArticleEntity> queryList(Map<String, Object> map){
		return articleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return articleDao.queryTotal(map);
	}
	
	@Override
	public void save(ArticleEntity article){
		articleDao.save(article);
	}
	
	@Override
	public void update(ArticleEntity article){
		articleDao.update(article);
	}
	
	@Override
	public void delete(String articleId){
		articleDao.delete(articleId);
	}
	
	@Override
	public void deleteBatch(String[] articleIds){
		articleDao.deleteBatch(articleIds);
	}
	
}
