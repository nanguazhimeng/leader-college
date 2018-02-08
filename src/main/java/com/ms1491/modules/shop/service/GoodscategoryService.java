package com.ms1491.modules.shop.service;

import com.ms1491.modules.article.entity.ThemeEntity;
import com.ms1491.modules.shop.entity.GoodscategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-29 14:19:52
 */
public interface GoodscategoryService {
	
	GoodscategoryEntity queryObject(String goodscategoryId);
	
	List<GoodscategoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodscategoryEntity goodscategory);
	
	void update(GoodscategoryEntity goodscategory);
	
	void delete(String goodscategoryId);
	
	void deleteBatch(String[] goodscategoryIds);
	
	List<GoodscategoryEntity> queryListParentId(String pid);
}
