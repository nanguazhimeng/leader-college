package com.ms1491.modules.appuser.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.modules.appuser.entity.AddressEntity;
import com.ms1491.modules.appuser.service.AddressService;
import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;


/**
 * 用户收获地址
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
@RestController
@RequestMapping("appuser/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("address:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AddressEntity> addressList = addressService.queryList(query);
		int total = addressService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{addressId}")
	@RequiresPermissions("address:info")
	public R info(@PathVariable("addressId") String addressId){
		AddressEntity address = addressService.queryObject(addressId);
		
		return R.ok().put("address", address);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("address:save")
	public R save(@RequestBody AddressEntity address){
		addressService.save(address);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("address:update")
	public R update(@RequestBody AddressEntity address){
		addressService.update(address);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("address:delete")
	public R delete(@RequestBody String[] addressIds){
		addressService.deleteBatch(addressIds);
		
		return R.ok();
	}
	
}
