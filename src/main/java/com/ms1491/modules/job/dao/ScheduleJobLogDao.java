package com.ms1491.modules.job.dao;

import com.ms1491.modules.job.entity.ScheduleJobLogEntity;
import com.ms1491.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2016年12月1日 下午10:30:02
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
