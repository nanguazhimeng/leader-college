package com.ms1491.modules.appuser.controller;

import java.util.List;
import java.util.Map;

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
import com.ms1491.modules.appuser.entity.MessageEntity;
import com.ms1491.modules.appuser.service.MessageService;


/**
 * 消息通知
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-05 17:57:30
 */
@RestController
@RequestMapping("appuser/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("message:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MessageEntity> messageList = messageService.queryList(query);
		int total = messageService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(messageList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("message:info")
	public R info(@PathVariable("id") String id){
		MessageEntity message = messageService.queryObject(id);
		
		return R.ok().put("message", message);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("message:save")
	public R save(@RequestBody MessageEntity message){
		messageService.save(message,null);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("message:update")
	public R update(@RequestBody MessageEntity message){
		messageService.update(message);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("message:delete")
	public R delete(@RequestBody String[] ids){
		messageService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
