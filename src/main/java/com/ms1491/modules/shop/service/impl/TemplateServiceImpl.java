package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.TemplateDao;
import com.ms1491.modules.shop.entity.TemplateEntity;
import com.ms1491.modules.shop.service.TemplateService;



@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	private TemplateDao templateDao;
	
	@Override
	public TemplateEntity queryObject(String templateId){
		return templateDao.queryObject(templateId);
	}
	
	@Override
	public List<TemplateEntity> queryList(Map<String, Object> map){
		return templateDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return templateDao.queryTotal(map);
	}
	
	@Override
	public void save(TemplateEntity template){
		templateDao.save(template);
	}
	
	@Override
	public void update(TemplateEntity template){
		templateDao.update(template);
	}
	
	@Override
	public void delete(String templateId){
		templateDao.delete(templateId);
	}
	
	@Override
	public void deleteBatch(String[] templateIds){
		templateDao.deleteBatch(templateIds);
	}
	
}
