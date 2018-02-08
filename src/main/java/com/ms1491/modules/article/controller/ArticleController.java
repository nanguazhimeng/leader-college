package com.ms1491.modules.article.controller;

import java.util.Date;
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
import com.ms1491.modules.article.entity.ArticleEntity;
import com.ms1491.modules.article.service.ArticleService;


/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-12-20 13:46:28
 */
@RestController
@RequestMapping("article/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("article:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ArticleEntity> articleList = articleService.queryList(query);
		int total = articleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(articleList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{articleId}")
	@RequiresPermissions("article:info")
	public R info(@PathVariable("articleId") String articleId){
		ArticleEntity article = articleService.queryObject(articleId);
		
		return R.ok().put("article", article);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("article:save")
	public R save(@RequestBody ArticleEntity article){
		ValidatorUtils.validateEntity(article,AddGroup.class);
		
		article.setArticleId(UUID.randomUUID().toString());
		article.setCreateTime(new Date());
		articleService.save(article);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("article:update")
	public R update(@RequestBody ArticleEntity article){
		ValidatorUtils.validateEntity(article,AddGroup.class);
		
		articleService.update(article);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("article:delete")
	public R delete(@RequestBody String[] articleIds){
		articleService.deleteBatch(articleIds);
		
		return R.ok();
	}
	
}
