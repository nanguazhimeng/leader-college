package com.ms1491.modules.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.AssertFalse;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.annotation.ApiLog;
import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.common.validator.Assert;
import com.ms1491.modules.api.annotation.AuthIgnore;
import com.ms1491.modules.api.annotation.LoginUser;
import com.ms1491.modules.api.utils.Condition;
import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.appuser.entity.MessageEntity;
import com.ms1491.modules.appuser.service.MessageService;
import com.ms1491.modules.college.entity.CollegeEntity;
import com.ms1491.modules.college.entity.CourseEntity;
import com.ms1491.modules.college.entity.UserCourseEntity;
import com.ms1491.modules.college.service.CollegeService;
import com.ms1491.modules.college.service.CourseService;
import com.ms1491.modules.college.service.UserCourseService;
import com.ms1491.modules.college.util.ConditionConstant;

/**
 * API学院
 *
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api/")
@Api(value="学院模块接口")
public class ApiCollegeController {
	@Autowired
	private CollegeService collegeService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserCourseService userCourseService;
	@Autowired
	private MessageService messageService;
	
    /**
     * 获取学院列表接口
     */
	@AuthIgnore
    @GetMapping("colllegeList")
    @ApiOperation(value="获取学院列表接口", notes="获取学院列表接口")
    public R colllegeList(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		List<CollegeEntity> collegeList = collegeService.queryList(map);
		if(collegeList!=null&&collegeList.size()>0){
			for (CollegeEntity collegeEntity : collegeList) {
				 List<Condition> conditions = new ArrayList<>();//筛选条件
				 List<String> items1 =ConditionConstant.STAR_TTIME_CONDITION; 
				 List<String> items2 =ConditionConstant.PLACE_CONDITION; 
				 List<String> items3 =ConditionConstant.LEADER_NAME_CONDITION; 
				 conditions.add(new Condition("时间","place", items1));
				 conditions.add(new Condition("地点", "leaderName",items2));
				 conditions.add(new Condition("讲师", "startTime",items3));
				 collegeEntity.setConditions(conditions);
			}
		}
        return R.ok().put("data", collegeList);
    }
    
    /**
     * 学院介绍接口
     */
	@AuthIgnore
    @GetMapping("collegeIntroduction")
    @ApiOperation(value="学院介绍接口", notes="学院介绍接口")
    public R collegeIntroduction(String collegeId){
    	Assert.isBlank(collegeId, "collegeId is null");
    	
		CollegeEntity college = collegeService.queryObject(collegeId);
        return R.ok().put("data", college.getCollegeIntroduction());
    }
    
    /**
     * 讲师介绍接口
     */
	@AuthIgnore
    @GetMapping("leaderIntroduction")
    @ApiOperation(value="讲师介绍接口", notes="讲师介绍接口")
    public R leaderIntroduction(String collegeId){
    	Assert.isBlank(collegeId, "collegeId is null");
    	
		CollegeEntity college = collegeService.queryObject(collegeId);
        return R.ok().put("data", college.getCollegeIntroduction());
    }
    /**
     * 课程体系接口
     */
	@AuthIgnore
    @GetMapping("courseSystem")
    @ApiOperation(value="课程体系接口", notes="课程体系接口")
    public R courseSystem(String collegeId){
    	Assert.isBlank(collegeId, "collegeId is null");
    	
		CollegeEntity college = collegeService.queryObject(collegeId);
        return R.ok().put("data", college.getCollegeIntroduction());
    }
    
    /**
     * 最新课表
     */
    @GetMapping("newCourseList")
    @ApiOperation(value="最新课表", notes="最新课表")
    public R newCourseList(@LoginUser AppUserEntity user,String collegeId,String page,String limit,String startTime,String place,String leaderName){
    	Assert.isBlank(collegeId, "collegeId is null");
    	Assert.isBlank(page, "page is null");
    	Assert.isBlank(limit, "limit is null");
    	
    	Map<String, Object> params = new HashMap<>();
    	params.put("page", page);
    	params.put("limit", limit);
    	params.put("sidx", "CREATE_TIME");
//    	params.put("order", "desc");
    	params.put("uid", user.getUserId());
    	params.put("collegeId", collegeId);
    	params.put("status", 0);
    	params.put("place", place);
    	params.put("leaderName", leaderName);
    	params.put("startTime", startTime);
    	
        Query query = new Query(params);
		List<CourseEntity> courseList = courseService.queryList(query);
		int total = courseService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(courseList, total, query.getLimit(), query.getPage());
		return R.ok().put("data", pageUtil);
    }
    /**
     * 往期精彩
     */
    @GetMapping("historyCourseList")
    @ApiOperation(value="往期精彩", notes="往期精彩")
    public R historyCourseList(String collegeId,String page,String limit){
    	Assert.isBlank(collegeId, "collegeId is null");
    	Assert.isBlank(page, "page is null");
    	Assert.isBlank(limit, "limit is null");
    	
    	Map<String, Object> params = new HashMap<>();
    	params.put("page", page);
    	params.put("limit", limit);
    	params.put("collegeId", collegeId);
    	params.put("status", 1);
        Query query = new Query(params);
    	
		List<CourseEntity> courseList = courseService.queryList(query);
		int total = courseService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(courseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("data", pageUtil);
    }
    
    /**
     * 课程细节
     */
    @GetMapping("courseIntroduction")
    @ApiOperation(value="课程细节", notes="课程细节")
    public R courseIntroduction(String courseId){
    	Assert.isBlank(courseId, "courseId is null");
    	
		CourseEntity course = courseService.queryObject(courseId);
        return R.ok().put("data", course.getCourseIntroduction());
    }
    
    /**
     * 精彩内容
     */
    @GetMapping("contentReview")
    @ApiOperation(value="精彩内容", notes="精彩内容")
    public R contentReview(String courseId){
    	Assert.isBlank(courseId, "courseId is null");
    	
		CourseEntity course = courseService.queryObject(courseId);
        return R.ok().put("data", course.getContentReview());
    }
    /**
     * 报名
     */
    @ApiLog("报名课程")
    @PostMapping("signupCourse")
    @ApiOperation(value="报名", notes="报名")
    public R signupCourse(@LoginUser AppUserEntity user,String courseId,String realname,String mobile,String weixinAccount){
    	Assert.isBlank(courseId, "courseId is null");
    	Assert.isBlank(realname, "realname is null");
    	Assert.isBlank(mobile, "mobile is null");
    	
    	CourseEntity course = courseService.signup(user.getUserId(),user.getRoleId(),courseId,realname,mobile,weixinAccount);
    	
    	
    	MessageEntity message = new MessageEntity();
    	message.setIsRead(false);
    	message.setTitle("报名成功");
    	message.setContent("您报名了《"+course.getName()+"》，开课时间为"+course.getStartTime()+",记得准时来听课哦！");
    	message.setUid(user.getUserId());
    	messageService.save(message,user.getExclusiveCode());
    	
        return R.ok();
    }
    /**
     * 已报名课程
     */
    @GetMapping("myCourseList")
    @ApiOperation(value="已报名课程", notes="已报名课程")
    public R myCourseList(@LoginUser AppUserEntity user,String page,String limit){
    	
    	Map<String, Object> params = new HashMap<>();
    	params.put("page", page);
    	params.put("limit", limit);
    	params.put("uid", user.getUserId());
        Query query = new Query(params);
		List<UserCourseEntity> usercourseList = userCourseService.queryList(query);
		int total = userCourseService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(usercourseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("data", pageUtil);
    }
    
}
