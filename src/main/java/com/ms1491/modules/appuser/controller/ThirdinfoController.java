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

import com.ms1491.modules.appuser.entity.ThirdinfoEntity;
import com.ms1491.modules.appuser.service.ThirdinfoService;
import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;


/**
 * 第三方账户信息
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
@RestController
@RequestMapping("appuser/thirdinfo")
public class ThirdinfoController {
	@Autowired
	private ThirdinfoService thirdinfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("thirdinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ThirdinfoEntity> thirdinfoList = thirdinfoService.queryList(query);
		int total = thirdinfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(thirdinfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{thirdUserId}")
	@RequiresPermissions("thirdinfo:info")
	public R info(@PathVariable("thirdUserId") String thirdUserId){
		ThirdinfoEntity thirdinfo = thirdinfoService.queryObject(thirdUserId);
		
		return R.ok().put("thirdinfo", thirdinfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("thirdinfo:save")
	public R save(@RequestBody ThirdinfoEntity thirdinfo){
		thirdinfoService.save(thirdinfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("thirdinfo:update")
	public R update(@RequestBody ThirdinfoEntity thirdinfo){
		thirdinfoService.update(thirdinfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("thirdinfo:delete")
	public R delete(@RequestBody String[] thirdUserIds){
		thirdinfoService.deleteBatch(thirdUserIds);
		
		return R.ok();
	}
	
}
