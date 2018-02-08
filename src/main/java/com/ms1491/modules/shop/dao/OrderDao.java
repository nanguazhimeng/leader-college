package com.ms1491.modules.shop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.api.entity.StoreOrderEntity;
import com.ms1491.modules.shop.entity.OrderEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 订单管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
 @Mapper
public interface OrderDao extends BaseDao<OrderEntity> {
	 
	 List<StoreOrderEntity> queryStoreOrderList(Map<String, Object> map);
	 
}
