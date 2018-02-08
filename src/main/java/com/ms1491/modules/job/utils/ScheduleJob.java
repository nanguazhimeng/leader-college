package com.ms1491.modules.job.utils;

import com.google.gson.Gson;
import com.ms1491.modules.job.entity.ScheduleJobEntity;
import com.ms1491.modules.job.entity.ScheduleJobLogEntity;
import com.ms1491.modules.job.service.ScheduleJobLogService;
import com.ms1491.common.utils.SpringContextUtils;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 定时任务
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2016年11月30日 下午12:44:21
 */
public class ScheduleJob extends QuartzJobBean {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ExecutorService service = Executors.newSingleThreadExecutor(); 
	
	//动态运行方法
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		String jsonJob = context.getMergedJobDataMap().getString(ScheduleJobEntity.JOB_PARAM_KEY);
		ScheduleJobEntity scheduleJob = new Gson().fromJson(jsonJob, ScheduleJobEntity.class);

		//获取spring bean
        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");
        
        //数据库保存执行记录
        ScheduleJobLogEntity log = new ScheduleJobLogEntity();
        log.setJobId(scheduleJob.getJobId());
        log.setBeanName(scheduleJob.getBeanName());
        log.setMethodName(scheduleJob.getMethodName());
        log.setParams(scheduleJob.getParams());
        log.setCreateTime(new Date());
        
        //任务开始时间
        long startTime = System.currentTimeMillis();
        
        try {
            //执行任务
        	logger.info("任务准备执行，任务ID：" + scheduleJob.getJobId());
            ScheduleRunnable task = new ScheduleRunnable(scheduleJob.getBeanName(), 
            		scheduleJob.getMethodName(), scheduleJob.getParams());
            
            //方法 execute(Runnable) 接收壹個 java.lang.Runnable 对象作为参数，并且以异步的方式执行它.使用这种方式没有办法获取执行 Runnable 之后的结果
            //方法 submit(Runnable) 同样接收壹個 Runnable 的实现作为参数，但是会返回壹個 Future 对象。这個 Future 对象可以用于判断 Runnable 是否结束执行。
            Future<?> future = service.submit(task);//
            
			future.get();//get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回
			
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			//任务状态    0：成功    1：失败
			log.setStatus(0);
			
			logger.info("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
		} catch (Exception e) {
			logger.error("任务执行失败，任务ID：" + scheduleJob.getJobId(), e);
			
			//任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			
			//任务状态    0：成功    1：失败
			log.setStatus(1);
			log.setError(StringUtils.substring(e.toString(), 0, 2000));
		}finally {
			scheduleJobLogService.save(log);
		}
    }
}
