package com.ms1491.modules.college.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.modules.college.entity.CollegeEntity;
import com.ms1491.modules.college.service.CollegeService;


/**
 * 学院
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
@RestController
@RequestMapping("college/college")
public class CollegeController {
	@Autowired
	private CollegeService collegeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("college:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CollegeEntity> collegeList = collegeService.queryList(query);
		int total = collegeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(collegeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 全部列表
	 */
	@RequestMapping("/listAll")
	@RequiresPermissions("college:list")
	public  List<CollegeEntity>  listAll(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		List<CollegeEntity> collegeList = collegeService.queryList(map);

		return collegeList;
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{collegeId}")
	@RequiresPermissions("college:info")
	public R info(@PathVariable("collegeId") String collegeId){
		CollegeEntity college = collegeService.queryObject(collegeId);
		
		return R.ok().put("college", college);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("college:save")
	public R save(@RequestBody CollegeEntity college){
		college.setCollegeId(UUID.randomUUID().toString());
		college.setCreateTime(new Date());
		
		collegeService.save(college);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("college:update")
	public R update(@RequestBody CollegeEntity college){
		collegeService.update(college);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("college:delete")
	public R delete(@RequestBody String[] collegeIds){
		collegeService.deleteBatch(collegeIds);
		
		return R.ok();
	}
	
}
