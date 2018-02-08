package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.CommissionlogDao;
import com.ms1491.modules.shop.entity.CommissionlogEntity;
import com.ms1491.modules.shop.service.CommissionlogService;



@Service("commissionlogService")
public class CommissionlogServiceImpl implements CommissionlogService {
	@Autowired
	private CommissionlogDao commissionlogDao;
	
	@Override
	public CommissionlogEntity queryObject(String commissionlogId){
		return commissionlogDao.queryObject(commissionlogId);
	}
	
	@Override
	public List<CommissionlogEntity> queryList(Map<String, Object> map){
		return commissionlogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return commissionlogDao.queryTotal(map);
	}
	
	@Override
	public void save(CommissionlogEntity commissionlog){
		commissionlogDao.save(commissionlog);
	}
	
	@Override
	public void update(CommissionlogEntity commissionlog){
		commissionlogDao.update(commissionlog);
	}
	
	@Override
	public void delete(String commissionlogId){
		commissionlogDao.delete(commissionlogId);
	}
	
	@Override
	public void deleteBatch(String[] commissionlogIds){
		commissionlogDao.deleteBatch(commissionlogIds);
	}
	
}
