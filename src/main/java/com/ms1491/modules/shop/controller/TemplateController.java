package com.ms1491.modules.shop.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.ms1491.modules.shop.entity.TemplateEntity;
import com.ms1491.modules.shop.service.TemplateService;


/**
 * 模板管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
@RestController
@RequestMapping("shop/template")
public class TemplateController {
	@Autowired
	private TemplateService templateService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("template:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TemplateEntity> templateList = templateService.queryList(query);
		int total = templateService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(templateList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{templateId}")
	@RequiresPermissions("template:info")
	public R info(@PathVariable("templateId") String templateId){
		TemplateEntity template = templateService.queryObject(templateId);
		
		return R.ok().put("template", template);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("template:save")
	public R save(@RequestBody TemplateEntity template){
		ValidatorUtils.validateEntity(template,AddGroup.class);
		
		template.setTemplateId(UUID.randomUUID().toString());
		templateService.save(template);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("template:update")
	public R update(@RequestBody TemplateEntity template){
		ValidatorUtils.validateEntity(template,UpdateGroup.class);
		
		templateService.update(template);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("template:delete")
	public R delete(@RequestBody String[] templateIds){
		templateService.deleteBatch(templateIds);
		
		return R.ok();
	}
	
}
