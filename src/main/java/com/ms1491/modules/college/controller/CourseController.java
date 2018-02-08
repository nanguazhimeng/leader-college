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
import com.ms1491.common.validator.ValidatorUtils;
import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.modules.college.entity.CourseEntity;
import com.ms1491.modules.college.service.CourseService;
import com.ms1491.modules.college.util.CollegeConstant;


/**
 * 学院课程

 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-12 16:33:47
 */
@RestController
@RequestMapping("college/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("course:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        params.put("sidx", "create_time");
        Query query = new Query(params);
		List<CourseEntity> courseList = courseService.queryList(query);
		int total = courseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(courseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{courseId}")
	@RequiresPermissions("course:info")
	public R info(@PathVariable("courseId") String courseId){
		CourseEntity course = courseService.queryObject(courseId);
		
		return R.ok().put("course", course);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("course:save")
	public R save(@RequestBody CourseEntity course){
		ValidatorUtils.validateEntity(course,AddGroup.class);
		
		if(CollegeConstant.SignupLimit.LIMIT_0.getValue()==course.getSignupLimit()){
			course.setSignupLimitContent("无级别限制");
		}else if(CollegeConstant.SignupLimit.LIMIT_1.getValue()==course.getSignupLimit()){
			course.setSignupLimitContent("直推30个下单客户");
		}else if(CollegeConstant.SignupLimit.LIMIT_2.getValue()==course.getSignupLimit()){
			course.setSignupLimitContent("市代以及以上");
		}
		course.setStatus(0);
		course.setCourseId(UUID.randomUUID().toString());
		course.setCreateTime(new Date());
		
		courseService.save(course);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("course:update")
	public R update(@RequestBody CourseEntity course){
		ValidatorUtils.validateEntity(course);
		
		if(CollegeConstant.SignupLimit.LIMIT_0.getValue()==course.getSignupLimit()){
			course.setSignupLimitContent("无级别限制");
		}else if(CollegeConstant.SignupLimit.LIMIT_1.getValue()==course.getSignupLimit()){
			course.setSignupLimitContent("直推30个下单客户");
		}else if(CollegeConstant.SignupLimit.LIMIT_2.getValue()==course.getSignupLimit()){
			course.setSignupLimitContent("市代以及以上");
		}
		courseService.update(course);
		
		return R.ok();
	}
	/**
	 * 结束
	 */
	@RequestMapping("/finish")
	@RequiresPermissions("course:finish")
	public R finish(@RequestBody String[] courseIds){
		courseService.finishBatch(courseIds);
		
		return R.ok();
	}
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("course:delete")
	public R delete(@RequestBody String[] courseIds){
		courseService.deleteBatch(courseIds);
		
		return R.ok();
	}
	
}
