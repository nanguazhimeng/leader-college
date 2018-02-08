package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.api.utils.GoodscategoryResponse;
import com.ms1491.modules.shop.dao.StoreGoodsDao;
import com.ms1491.modules.shop.entity.StoreGoodsEntity;
import com.ms1491.modules.shop.service.StoreGoodsService;



@Service("storeGoodsService")
public class StoreGoodsServiceImpl implements StoreGoodsService {
	@Autowired
	private StoreGoodsDao storeGoodsDao;
	
	@Override
	public StoreGoodsEntity queryObject(String storeGoodsId){
		return storeGoodsDao.queryObject(storeGoodsId);
	}
	
	@Override
	public List<StoreGoodsEntity> queryList(Map<String, Object> map){
		return storeGoodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return storeGoodsDao.queryTotal(map);
	}
	
	@Override
	public void save(StoreGoodsEntity storeGoods){
		storeGoodsDao.save(storeGoods);
	}
	
	@Override
	public void update(StoreGoodsEntity storeGoods){
		storeGoodsDao.update(storeGoods);
	}
	
	@Override
	public void delete(String storeGoodsId){
		storeGoodsDao.delete(storeGoodsId);
	}
	
	@Override
	public void deleteBatch(String[] storeGoodsIds){
		storeGoodsDao.deleteBatch(storeGoodsIds);
	}

	@Override
	public StoreGoodsEntity queryObjectByStoreIdAndGoodsId(
			Map<String, Object> map) {
		return storeGoodsDao.queryObjectByStoreIdAndGoodsId(map);
	}

	@Override
	public List<GoodscategoryResponse> queryCategoryList(Map<String, Object> map) {
		return storeGoodsDao.queryCategoryList(map);
	}
	
}
