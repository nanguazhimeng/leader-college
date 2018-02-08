package com.ms1491.modules.shop.controller;

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
import com.ms1491.modules.shop.entity.CommissionlogEntity;
import com.ms1491.modules.shop.service.CommissionlogService;


/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-10-10 15:06:31
 */
@RestController
@RequestMapping("shop/commissionlog")
public class CommissionlogController {
	@Autowired
	private CommissionlogService commissionlogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("commissionlog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CommissionlogEntity> commissionlogList = commissionlogService.queryList(query);
		int total = commissionlogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(commissionlogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{commissionlogId}")
	@RequiresPermissions("commissionlog:info")
	public R info(@PathVariable("commissionlogId") String commissionlogId){
		CommissionlogEntity commissionlog = commissionlogService.queryObject(commissionlogId);
		
		return R.ok().put("commissionlog", commissionlog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("commissionlog:save")
	public R save(@RequestBody CommissionlogEntity commissionlog){
		commissionlogService.save(commissionlog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("commissionlog:update")
	public R update(@RequestBody CommissionlogEntity commissionlog){
		commissionlogService.update(commissionlog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("commissionlog:delete")
	public R delete(@RequestBody String[] commissionlogIds){
		commissionlogService.deleteBatch(commissionlogIds);
		
		return R.ok();
	}
	
}
