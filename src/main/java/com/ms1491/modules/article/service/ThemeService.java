package com.ms1491.modules.article.service;

import com.ms1491.modules.article.entity.ThemeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-12-20 13:46:28
 */
public interface ThemeService {
	
	ThemeEntity queryObject(String themeId);
	
	List<ThemeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ThemeEntity theme);
	
	void update(ThemeEntity theme);
	
	void delete(String themeId);
	
	void deleteBatch(String[] themeIds);
	
	List<ThemeEntity> queryListParentId(String themeId);
}
