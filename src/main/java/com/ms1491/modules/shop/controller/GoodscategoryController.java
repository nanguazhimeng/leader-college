package com.ms1491.modules.shop.controller;

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
import com.ms1491.modules.shop.entity.GoodscategoryEntity;
import com.ms1491.modules.shop.service.GoodscategoryService;
import com.ms1491.modules.sys.entity.SysMenuEntity;


/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-29 14:19:52
 */
@RestController
@RequestMapping("shop/goodscategory")
public class GoodscategoryController {
	@Autowired
	private GoodscategoryService goodscategoryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("goodscategory:list")
	public List<GoodscategoryEntity> list(){
		//查询列表数据
		List<GoodscategoryEntity> goodscategoryList = goodscategoryService.queryList(new HashMap<String, Object>());
//		//添加顶级菜单
//		GoodscategoryEntity root = new GoodscategoryEntity();
//		root.setGoodscategoryId("0");
//		root.setName("一级分类");
//		root.setPid("-1");
//		root.setOpen(true);
//		goodscategoryList.add(root);
		return goodscategoryList;
		}
	/**
	 * 选择列表
	 */
	@RequestMapping("/select")
	@RequiresPermissions("goodscategory:list")
	public  R  select(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		
		List<GoodscategoryEntity> goodscategoryList = goodscategoryService.queryList(map);
		//添加顶级菜单
		GoodscategoryEntity root = new GoodscategoryEntity();
		root.setGoodscategoryId("0");
		root.setName("一级分类");
		root.setPid("-1");
		root.setOpen(true);
		goodscategoryList.add(root);
		return R.ok().put("goodscategoryList", goodscategoryList);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{goodscategoryId}")
	@RequiresPermissions("goodscategory:info")
	public R info(@PathVariable("goodscategoryId") String goodscategoryId){
		GoodscategoryEntity goodscategory = goodscategoryService.queryObject(goodscategoryId);
		
		return R.ok().put("goodscategory", goodscategory);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("goodscategory:save")
	public R save(@RequestBody GoodscategoryEntity goodscategory){
		goodscategory.setGoodscategoryId(UUID.randomUUID().toString());
		goodscategoryService.save(goodscategory);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("goodscategory:update")
	public R update(@RequestBody GoodscategoryEntity goodscategory){
		goodscategoryService.update(goodscategory);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("goodscategory:delete")
	public R delete(String goodscategoryId){

		//判断是否有子菜单或按钮
		List<GoodscategoryEntity> goodscategoryList = goodscategoryService.queryListParentId(goodscategoryId);
		if(goodscategoryList.size() > 0){
			return R.error("请先删除分类");
		}

		goodscategoryService.deleteBatch(new String[]{goodscategoryId});
		return R.ok();
	}
	
}
