package com.ms1491.modules.appuser.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.appuser.entity.MessageEntity;
import com.ms1491.modules.sys.dao.BaseDao;

/**
 * 消息通知
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
@Mapper
public interface MessageDao extends BaseDao<MessageEntity> {
	void updateToRead(Object uid);
}
