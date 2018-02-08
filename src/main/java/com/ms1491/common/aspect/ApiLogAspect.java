package com.ms1491.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.ms1491.common.annotation.ApiLog;
import com.ms1491.common.utils.HttpContextUtils;
import com.ms1491.common.utils.IPUtils;
import com.ms1491.modules.api.interceptor.AuthorizationInterceptor;
import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.sys.entity.SysLogEntity;


/**
 * 系统日志，切面处理类
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
public class ApiLogAspect {
	@Autowired
	StringRedisTemplate template;
	@Autowired
	CountDownLatch latch;
	
	@Pointcut("@annotation(com.ms1491.common.annotation.ApiLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;

		//保存日志
		saveSysLog(point, time);

		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogEntity sysLog = new SysLogEntity();
		ApiLog apilog = method.getAnnotation(ApiLog.class);
		if(apilog != null){
			//注解上的描述
			sysLog.setOperation(apilog.value());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		//请求的参数
		Object[] args = joinPoint.getArgs();
		//用户名
		AppUserEntity appuser = (AppUserEntity) args[0];
        sysLog.setUsername(appuser.getUsername());
		try{
			String params = new Gson().toJson(args);
			sysLog.setParams(params);
		}catch (Exception e){
			
		}
		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));
		
		sysLog.setTime(time);
		
		sysLog.setCreateDate(new Date());
		//保存系统日志
		JSONObject json = JSONObject.fromObject(sysLog);
		
		template.convertAndSend("message:apilog",json.toString());
	}

	
}
