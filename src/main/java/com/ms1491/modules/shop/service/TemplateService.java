package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.TemplateEntity;

import java.util.List;
import java.util.Map;

/**
 * 模板管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public interface TemplateService {
	
	TemplateEntity queryObject(String templateId);
	
	List<TemplateEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TemplateEntity template);
	
	void update(TemplateEntity template);
	
	void delete(String templateId);
	
	void deleteBatch(String[] templateIds);
}
