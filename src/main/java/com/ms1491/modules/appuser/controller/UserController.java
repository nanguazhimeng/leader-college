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

import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.appuser.service.AppUserService;


/**
 * app用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:29
 */
@RestController
@RequestMapping("appuser/user")
public class UserController {
	@Autowired
	private AppUserService userService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AppUserEntity> userList = userService.queryList(query);
		int total = userService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("user:info")
	public R info(@PathVariable("userId") String userId){
		AppUserEntity user = userService.queryObject(userId);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:save")
	public R save(@RequestBody AppUserEntity user){
		userService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:update")
	public R update(@RequestBody AppUserEntity user){
		userService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:delete")
	public R delete(@RequestBody String[] userIds){
		userService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
