package com.ms1491.modules.article.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.R;
import com.ms1491.common.validator.ValidatorUtils;
import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.common.validator.group.UpdateGroup;
import com.ms1491.modules.article.entity.ThemeEntity;
import com.ms1491.modules.article.service.ThemeService;


/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-12-20 13:46:28
 */
@RestController
@RequestMapping("article/theme")
public class ThemeController {
	@Autowired
	private ThemeService themeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("theme:list")
	public  List<ThemeEntity>  list(){
		//查询列表数据
		List<ThemeEntity> themeList = themeService.queryList(new HashMap<String, Object>());

		return themeList;
	}
	/**
	 * 全部列表
	 */
	@RequestMapping("/listAll")
	@RequiresPermissions("theme:list")
	public  List<ThemeEntity>  listAll(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		
		List<ThemeEntity> themeList = themeService.queryList(map);
		
		return themeList;
	}
	
	/**
	 * 根列表
	 */
	@RequestMapping("/selectTheme")
	@RequiresPermissions("theme:list")
	public  List<ThemeEntity>  selectTheme(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		
		map.put("type", 0);
		List<ThemeEntity> themeList = themeService.queryList(map);
		
		return themeList;
	}
	
	/**
	 * 选择列表
	 */
	@RequestMapping("/select")
	@RequiresPermissions("theme:list")
	public  R  select(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		
		List<ThemeEntity> themeList = themeService.queryList(map);
		
		return R.ok().put("themeList", themeList);
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{themeId}")
	@RequiresPermissions("theme:info")
	public R info(@PathVariable("themeId") String themeId){
		ThemeEntity theme = themeService.queryObject(themeId);
		
		return R.ok().put("theme", theme);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("theme:save")
	public R save(@RequestBody ThemeEntity theme){
		ValidatorUtils.validateEntity(theme,AddGroup.class);
		
		theme.setThemeId(UUID.randomUUID().toString());
		theme.setCreateTime(new Date());
		themeService.save(theme);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("theme:update")
	public R update(@RequestBody ThemeEntity theme){
		ValidatorUtils.validateEntity(theme,UpdateGroup.class);
		themeService.update(theme);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("theme:delete")
	public R delete(String themeId){

		//判断是否有子菜单或按钮
		List<ThemeEntity> themeList = themeService.queryListParentId(themeId);
		if(themeList.size() > 0){
			return R.error("请先删除子菜单或按钮");
		}

		themeService.deleteBatch(new String[]{themeId});
		return R.ok();
	}
	
}
