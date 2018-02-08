package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.OrdergoodsDao;
import com.ms1491.modules.shop.entity.OrdergoodsEntity;
import com.ms1491.modules.shop.service.OrdergoodsService;



@Service("ordergoodsService")
public class OrdergoodsServiceImpl implements OrdergoodsService {
	@Autowired
	private OrdergoodsDao ordergoodsDao;
	
	@Override
	public OrdergoodsEntity queryObject(String ordergoodsId){
		return ordergoodsDao.queryObject(ordergoodsId);
	}
	
	@Override
	public List<OrdergoodsEntity> queryList(Map<String, Object> map){
		return ordergoodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ordergoodsDao.queryTotal(map);
	}
	
	@Override
	public void save(OrdergoodsEntity ordergoods){
		ordergoodsDao.save(ordergoods);
	}
	
	@Override
	public void update(OrdergoodsEntity ordergoods){
		ordergoodsDao.update(ordergoods);
	}
	
	@Override
	public void delete(String ordergoodsId){
		ordergoodsDao.delete(ordergoodsId);
	}
	
	@Override
	public void deleteBatch(String[] ordergoodsIds){
		ordergoodsDao.deleteBatch(ordergoodsIds);
	}
	
}
