package com.ms1491.modules.college.controller;

import java.util.Date;
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
import com.ms1491.modules.college.entity.UserCourseEntity;
import com.ms1491.modules.college.service.UserCourseService;


/**
 * 用户-课程关系
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
@RestController
@RequestMapping("college/usercourse")
public class UserCourseController {
	@Autowired
	private UserCourseService userCourseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("usercourse:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        params.put("sidx", "create_time");
        params.put("order", "desc");
        Query query = new Query(params);
		List<UserCourseEntity> userCourseList = userCourseService.queryList(query);
		int total = userCourseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userCourseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("usercourse:info")
	public R info(@PathVariable("id") String id){
		UserCourseEntity userCourse = userCourseService.queryObject(id);
		
		return R.ok().put("userCourse", userCourse);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("usercourse:save")
	public R save(@RequestBody UserCourseEntity userCourse){
		userCourse.setId(UUID.randomUUID().toString());
		userCourse.setCreateTime(new Date());
		
		userCourseService.save(userCourse);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("usercourse:update")
	public R update(@RequestBody UserCourseEntity userCourse){
		userCourseService.update(userCourse);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("usercourse:delete")
	public R delete(@RequestBody String[] ids){
		userCourseService.deleteBatch(ids);
		
		return R.ok();
	}
	/**
	 * 确认
	 */
	@RequestMapping("/finish")
	@RequiresPermissions("course:finish")
	public R finish(@RequestBody String[] ids){
		userCourseService.finishBatch(ids);
		
		return R.ok();
	}
}
