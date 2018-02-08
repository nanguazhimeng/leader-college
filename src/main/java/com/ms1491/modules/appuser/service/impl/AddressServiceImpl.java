package com.ms1491.modules.appuser.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1491.modules.appuser.dao.AddressDao;
import com.ms1491.modules.appuser.entity.AddressEntity;
import com.ms1491.modules.appuser.service.AddressService;



@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public AddressEntity queryObject(String addressId){
		return addressDao.queryObject(addressId);
	}
	
	@Override
	public List<AddressEntity> queryList(Map<String, Object> map){
		return addressDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return addressDao.queryTotal(map);
	}
	
	@Override
	public void save(AddressEntity address){
		addressDao.save(address);
	}
	
	@Override
	public void update(AddressEntity address){
		addressDao.update(address);
	}
	
	@Override
	public void delete(String addressId){
		addressDao.delete(addressId);
	}
	
	@Override
	public void deleteBatch(String[] addressIds){
		addressDao.deleteBatch(addressIds);
	}
	
}
