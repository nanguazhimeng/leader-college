package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.GoodscategoryDao;
import com.ms1491.modules.shop.entity.GoodscategoryEntity;
import com.ms1491.modules.shop.service.GoodscategoryService;



@Service("goodscategoryService")
public class GoodscategoryServiceImpl implements GoodscategoryService {
	@Autowired
	private GoodscategoryDao goodscategoryDao;
	
	@Override
	public GoodscategoryEntity queryObject(String goodscategoryId){
		return goodscategoryDao.queryObject(goodscategoryId);
	}
	
	@Override
	public List<GoodscategoryEntity> queryList(Map<String, Object> map){
		return goodscategoryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodscategoryDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodscategoryEntity goodscategory){
		goodscategoryDao.save(goodscategory);
	}
	
	@Override
	public void update(GoodscategoryEntity goodscategory){
		goodscategoryDao.update(goodscategory);
	}
	
	@Override
	public void delete(String goodscategoryId){
		goodscategoryDao.delete(goodscategoryId);
	}
	
	@Override
	public void deleteBatch(String[] goodscategoryIds){
		goodscategoryDao.deleteBatch(goodscategoryIds);
	}

	@Override
	public List<GoodscategoryEntity> queryListParentId(String pid) {
		return goodscategoryDao.queryListParentId(pid);
	}
	
}
