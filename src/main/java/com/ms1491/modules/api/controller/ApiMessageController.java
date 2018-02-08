package com.ms1491.modules.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.common.validator.Assert;
import com.ms1491.modules.api.annotation.LoginUser;
import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.appuser.entity.MessageEntity;
import com.ms1491.modules.appuser.service.MessageService;

/**
 * 消息通知接口
 *
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api("消息通知接口")
public class ApiMessageController {
	@Autowired
	private MessageService messageService;
	
	/**
	 * 消息通知列表
	 * @return
	 */
    @GetMapping("messageList")
    @ApiOperation(value="消息通知列表接口", notes="消息通知列表接口")
	public R messageList(@LoginUser AppUserEntity user,String page,String limit){
    	Assert.isBlank(page, "page is null");
    	Assert.isBlank(limit, "limit is null");
    	
    	Map<String, Object> params = new HashMap<>();
    	params.put("sidx", "CREATE_TIME");
    	params.put("order", "DESC");
    	params.put("uid", user.getUserId());
    	params.put("page", page);
    	params.put("limit", limit);
        Query query = new Query(params);
        
		List<MessageEntity> messageList = messageService.queryList(query);
		int total = messageService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(messageList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("data", pageUtil);
		
	}
	/**
	 * 消息设置已读
	 * @return
	 */
    @PostMapping("readMessage")
    @ApiOperation(value="消息设置已读接口", notes="消息设置已读接口")
	public R readMessage(@LoginUser AppUserEntity user){
    	
    	messageService.updateToRead(user.getUserId());
		
		return R.ok();
	}
    
	/**
	 * 删除消息
	 * @return
	 */
    @PostMapping("deleteMessage")
    @ApiOperation(value="删除消息接口", notes="删除消息接口")
	public R deleteMessage(@LoginUser AppUserEntity user,String messageId){
    	Assert.isBlank(messageId, "messageId is null");
    	
    	messageService.delete(messageId);
		return R.ok();
	}
}
