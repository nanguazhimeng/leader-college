package com.ms1491.modules.appuser.service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.appuser.entity.MessageEntity;

/**
 * 消息通知
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
public interface MessageService {
	
	MessageEntity queryObject(String id);
	
	List<MessageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MessageEntity message,String alia);
	
	void update(MessageEntity message);
	
	void updateToRead(String uid);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	public void saveBatch(String title,String content, List<String> uidList);
}
