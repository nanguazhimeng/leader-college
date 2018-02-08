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

import com.ms1491.modules.appuser.entity.RelationshipEntity;
import com.ms1491.modules.appuser.service.RelationshipService;
import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;


/**
 * 上下级关系表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
@RestController
@RequestMapping("appuser/relationship")
public class RelationshipController {
	@Autowired
	private RelationshipService relationshipService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("relationship:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RelationshipEntity> relationshipList = relationshipService.queryList(query);
		int total = relationshipService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(relationshipList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	/**
	 * 列表
	 */
	@RequestMapping("/sublist")
	@RequiresPermissions("relationship:list")
	public R sublist(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RelationshipEntity> relationshipList = relationshipService.queryList(query);
		int total = relationshipService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(relationshipList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{relationshipId}")
	@RequiresPermissions("relationship:info")
	public R info(@PathVariable("relationshipId") String relationshipId){
		RelationshipEntity relationship = relationshipService.queryObject(relationshipId);
		
		return R.ok().put("relationship", relationship);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("relationship:save")
	public R save(@RequestBody RelationshipEntity relationship){
		relationshipService.save(relationship);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("relationship:update")
	public R update(@RequestBody RelationshipEntity relationship){
		relationshipService.update(relationship);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("relationship:delete")
	public R delete(@RequestBody String[] relationshipIds){
		relationshipService.deleteBatch(relationshipIds);
		
		return R.ok();
	}
	
}
