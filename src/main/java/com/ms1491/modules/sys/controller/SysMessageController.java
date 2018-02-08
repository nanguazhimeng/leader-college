package com.ms1491.modules.sys.controller;

import java.util.Date;
import java.util.LinkedList;
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
import com.ms1491.common.validator.ValidatorUtils;
import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.common.validator.group.UpdateGroup;
import com.ms1491.modules.api.utils.JpushUtil;
import com.ms1491.modules.appuser.service.MessageService;
import com.ms1491.modules.sys.entity.SysMessageEntity;
import com.ms1491.modules.sys.service.SysMessageService;


/**
 * 系统消息
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-22 12:11:32
 */
@RestController
@RequestMapping("sys/message")
public class SysMessageController {
	@Autowired
	private SysMessageService sysMessageService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private JpushUtil jpushUtil;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:message:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysMessageEntity> sysMessageList = sysMessageService.queryList(query);
		int total = sysMessageService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysMessageList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:message:info")
	public R info(@PathVariable("id") Integer id){
		SysMessageEntity sysMessage = sysMessageService.queryObject(id);
		
		return R.ok().put("sysMessage", sysMessage);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:message:save")
	public R save(@RequestBody SysMessageEntity sysMessage){
		ValidatorUtils.validateEntity(sysMessage,AddGroup.class);
		
		if(sysMessage.getStatus()==1){
			notifyToAll(sysMessage.getTitle(), sysMessage.getContent());
		}
		sysMessage.setCreateTime(new Date());
		sysMessageService.save(sysMessage);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:message:update")
	public R update(@RequestBody SysMessageEntity sysMessage){
		ValidatorUtils.validateEntity(sysMessage,UpdateGroup.class);
		
		if(sysMessage.getStatus()==1){
			notifyToAll(sysMessage.getTitle(), sysMessage.getContent());
		}
		sysMessageService.update(sysMessage);
		
		return R.ok();
	}
	/**
	 * 发布
	 */
	@RequestMapping("/publish")
	@RequiresPermissions("sys:message:publish")
	public R publish(@RequestBody Integer[] ids){
		sysMessageService.publishBatch(ids);
		
		return R.ok();
	}
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:message:delete")
	public R delete(@RequestBody Integer[] ids){
		sysMessageService.deleteBatch(ids);
		
		return R.ok();
	}
	
	//发通知给所有人
	private void notifyToAll(String title,String content){
		jpushUtil.pushNotifyToAll(title, content);
		List<String> uidList = new LinkedList<String>();//待补充
		
		messageService.saveBatch(title, content, uidList);
	}
}
