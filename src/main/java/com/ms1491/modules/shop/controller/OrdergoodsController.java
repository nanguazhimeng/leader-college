package com.ms1491.modules.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.modules.shop.entity.OrdergoodsEntity;
import com.ms1491.modules.shop.service.OrdergoodsService;


/**
 * 订单商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
@RestController
@RequestMapping("shop/ordergoods")
public class OrdergoodsController {
	@Autowired
	private OrdergoodsService ordergoodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list/{orderId}")
	@RequiresPermissions("order:list")
	public R list(@PathVariable("orderId") String orderId){
		//查询列表数据
		Map<String, Object> params = new HashMap<>();
		params.put("orderId", orderId);
		List<OrdergoodsEntity> ordergoodsList = ordergoodsService.queryList(params);
		
		return R.ok().put("ordergoodsList", ordergoodsList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{ordergoodsId}")
	@RequiresPermissions("order:info")
	public R info(@PathVariable("ordergoodsId") String ordergoodsId){
		OrdergoodsEntity ordergoods = ordergoodsService.queryObject(ordergoodsId);
		
		return R.ok().put("ordergoods", ordergoods);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("order:save")
	public R save(@RequestBody OrdergoodsEntity ordergoods){
		ordergoodsService.save(ordergoods);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("order:update")
	public R update(@RequestBody OrdergoodsEntity ordergoods){
		ordergoodsService.update(ordergoods);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("order:delete")
	public R delete(@RequestBody String[] ordergoodsIds){
		ordergoodsService.deleteBatch(ordergoodsIds);
		
		return R.ok();
	}
	
}
