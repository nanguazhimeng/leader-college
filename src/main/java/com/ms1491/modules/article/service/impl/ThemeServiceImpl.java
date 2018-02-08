package com.ms1491.modules.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1491.modules.article.dao.ThemeDao;
import com.ms1491.modules.article.entity.ThemeEntity;
import com.ms1491.modules.article.service.ThemeService;



@Service("themeService")
public class ThemeServiceImpl implements ThemeService {
	@Autowired
	private ThemeDao themeDao;
	
	@Override
	public ThemeEntity queryObject(String themeId){
		return themeDao.queryObject(themeId);
	}
	
	@Override
	public List<ThemeEntity> queryList(Map<String, Object> map){
		return themeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return themeDao.queryTotal(map);
	}
	
	@Override
	public void save(ThemeEntity theme){
		themeDao.save(theme);
	}
	
	@Override
	public void update(ThemeEntity theme){
		themeDao.update(theme);
	}
	
	@Override
	public void delete(String themeId){
		themeDao.delete(themeId);
	}
	
	@Override
	public void deleteBatch(String[] themeIds){
		themeDao.deleteBatch(themeIds);
	}

	@Override
	public List<ThemeEntity> queryListParentId(String parentId) {
		return themeDao.queryListParentId(parentId);
	}
	
}
