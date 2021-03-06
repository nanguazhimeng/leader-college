package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.GoodsDao;
import com.ms1491.modules.shop.entity.GoodsEntity;
import com.ms1491.modules.shop.service.GoodsService;



@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public GoodsEntity queryObject(String goodsId){
		return goodsDao.queryObject(goodsId);
	}
	
	@Override
	public List<GoodsEntity> queryList(Map<String, Object> map){
		return goodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodsEntity goods){
		goodsDao.save(goods);
	}
	
	@Override
	public void update(GoodsEntity goods){
		goodsDao.update(goods);
	}
	
	@Override
	public void delete(String goodsId){
		goodsDao.delete(goodsId);
	}
	
	@Override
	public void deleteBatch(String[] goodsIds){
		goodsDao.deleteBatch(goodsIds);
	}
	
}
