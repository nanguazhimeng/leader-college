package com.ms1491.modules.college.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms1491.common.exception.RRException;
import com.ms1491.modules.api.utils.ApiCode;
import com.ms1491.modules.api.utils.RoleIdContant;
import com.ms1491.modules.college.dao.CourseDao;
import com.ms1491.modules.college.dao.UserCourseDao;
import com.ms1491.modules.college.entity.CourseEntity;
import com.ms1491.modules.college.entity.UserCourseEntity;
import com.ms1491.modules.college.service.CourseService;
import com.ms1491.modules.college.util.CollegeConstant;
import com.ms1491.modules.shop.dao.CommissionlogDao;



@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private UserCourseDao userCourseDao;
	@Autowired
	private CommissionlogDao commissionlogDao;
	
	@Override
	public CourseEntity queryObject(String courseId){
		return courseDao.queryObject(courseId);
	}
	
	@Override
	public List<CourseEntity> queryList(Map<String, Object> map){
		return courseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return courseDao.queryTotal(map);
	}
	
	@Override
	public void save(CourseEntity course){
		courseDao.save(course);
	}
	
	@Override
	public void update(CourseEntity course){
		courseDao.update(course);
	}
	
	@Override
	public void delete(String courseId){
		courseDao.delete(courseId);
	}
	
	@Override
	public void deleteBatch(String[] courseIds){
		courseDao.deleteBatch(courseIds);
	}
	@Override
	public void finishBatch(String[] courseIds){
		courseDao.finishBatch(courseIds);
	}
	@Transactional
	@Override
	public CourseEntity signup(String uid, String roleId, String courseId,
			String realname, String mobile, String weixinAccount) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("uid", uid);
    	params.put("courseId", courseId);
    	CourseEntity course = courseDao.queryObjectByUidAndCourseId(params);
    	if(course.getHasSignup()>0){//已报名
    		throw new RRException("你已报名成功,请勿重复报名!",ApiCode.AC_OTHER_ERROR);
    	}
    	int signupLimit = course.getSignupLimit();
		if(CollegeConstant.SignupLimit.LIMIT_0.getValue()==signupLimit){//无级别限制
			
		}else if(CollegeConstant.SignupLimit.LIMIT_1.getValue()==signupLimit){//直推30个下单客户
			if(!isShidaiUp(roleId)&&!zhitui_30(uid)){
				throw new RRException("抱歉，您尚未获得报名资格！",ApiCode.AC_OTHER_ERROR);
			}
		}else if(CollegeConstant.SignupLimit.LIMIT_2.getValue()==signupLimit){//市代以及以上
			if(!isShidaiUp(roleId)){
				throw new RRException("抱歉，您尚未获得报名资格！",ApiCode.AC_OTHER_ERROR);
			}
		}
    	UserCourseEntity userCourseEntity = new UserCourseEntity();
    	userCourseEntity.setId(UUID.randomUUID().toString());
    	userCourseEntity.setUid(uid);
    	userCourseEntity.setCourseId(courseId);
    	userCourseEntity.setRealname(realname);
    	userCourseEntity.setMobile(mobile);
    	userCourseEntity.setWeixinAccount(weixinAccount);
    	userCourseEntity.setCreateTime(new Date());
    	userCourseDao.save(userCourseEntity);
    	return course;
	}
	//市代及以上
	private boolean isShidaiUp(String roleId){
		if(	RoleIdContant.SHIDAI.equals(roleId)||
		   RoleIdContant.SHENGDAI.equals(roleId)||
		   RoleIdContant.DONGSHI_C.equals(roleId)||
		   RoleIdContant.DONGSHI_B.equals(roleId)||
		   RoleIdContant.DONGSHI_A.equals(roleId)||
		   RoleIdContant.ZHIDAOSHI.equals(roleId)||
		   RoleIdContant.QUYU_ZONGJINGLI.equals(roleId)||
		   RoleIdContant.ZONGJINGLI.equals(roleId)){
			return true;
		}else{
			return false;
		}
	}
	//直推30个
	private boolean zhitui_30(String uid){
		boolean result = false;
		Map<String, Object> params = new HashMap<>();
		params.put("uid", uid);
		int count = commissionlogDao.queryTotal(params);params=null;
		if(count>=30){
			result = true;
		}
		return result;	
	}
}
