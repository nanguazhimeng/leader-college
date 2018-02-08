package com.ms1491.modules.appuser.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1491.modules.api.utils.JpushUtil;
import com.ms1491.modules.appuser.dao.MessageDao;
import com.ms1491.modules.appuser.entity.MessageEntity;
import com.ms1491.modules.appuser.service.MessageService;



@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	@Autowired
	JpushUtil jpushUtil;
	
	@Override
	public MessageEntity queryObject(String id){
		return messageDao.queryObject(id);
	}
	
	@Override
	public List<MessageEntity> queryList(Map<String, Object> map){
		return messageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return messageDao.queryTotal(map);
	}
	
	@Override
	public void save(MessageEntity message,String alia){
		Map<String, Object> map = new HashMap<>();
		map.put("title", message.getTitle());
		map.put("content", message.getContent());
		map.put("isRead", 0);
		List<String> uidList = new ArrayList<>();
		uidList.add(message.getUid());
		map.put("uidList", uidList);
		map.put("createTime", new Date());
		if(StringUtils.isNotEmpty(alia)){
			jpushUtil.pushNotify(message.getTitle(), message.getContent(), alia, null);
		}
		messageDao.save(map);
	}
	@Override
	public void saveBatch(String title,String content, List<String> uidList){
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		map.put("isRead", 0);
		map.put("uidList", uidList);
		map.put("createTime",new Date());
		messageDao.save(map);
	}
	@Override
	public void update(MessageEntity message){
		messageDao.update(message);
	}
	
	@Override
	public void delete(String id){
		messageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		messageDao.deleteBatch(ids);
	}

	@Override
	public void updateToRead(String uid) {
		messageDao.updateToRead(uid);
	}
	
}
