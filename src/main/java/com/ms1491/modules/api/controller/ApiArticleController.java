package com.ms1491.modules.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.common.validator.Assert;
import com.ms1491.modules.api.annotation.AuthIgnore;
import com.ms1491.modules.api.annotation.SignIgnore;
import com.ms1491.modules.article.entity.ArticleEntity;
import com.ms1491.modules.article.entity.ThemeEntity;
import com.ms1491.modules.article.service.ArticleService;
import com.ms1491.modules.article.service.ThemeService;

/**
 * API文章内容管理
 *
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api/")
@Api(value="文章模块接口")
public class ApiArticleController {
	@Autowired
	private ThemeService themeService;
	@Autowired
	private ArticleService articleService;
	
    /**
     * 获取主题列表接口
     */
	@AuthIgnore
	@SignIgnore
    @GetMapping("themeList")
    @ApiOperation(value="获取主题列表接口", notes="获取主题列表接口")
    public R themeList(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		map.put("sidx", "play_order");
		map.put("order", "asc");
		
		List<ThemeEntity> returnList = new LinkedList<>();
		List<ThemeEntity> themeList = themeService.queryList(map);
		if(themeList!=null&&themeList.size()>0){
			
			for (ThemeEntity themeEntity1 : themeList) {
				if(themeEntity1.getType()==0){
					returnList.add(themeEntity1);
					List<ThemeEntity> list = new LinkedList<>();
					themeEntity1.setList(list);
					for(int i=0;i<themeList.size();i++){
						if(themeEntity1.getThemeId().equals(themeList.get(i).getParentId())){
							list.add(themeList.get(i));
						}
					}
				}
				
			}
		}
        return R.ok().put("data", returnList);
    }
    /**
     * 获取文章/音频/视频列表接口
     */
	@AuthIgnore
	@SignIgnore
    @GetMapping("articleList")
    @ApiOperation(value="获取文章/音频/视频列表接口", notes="获取文章/音频/视频列表接口")
    public R articleList(String themeId,String page,String limit){
		Assert.isBlank(themeId, "themeId is null");
		Assert.isBlank(page, "page is null");
		Assert.isBlank(limit, "limit is null");
		
		//查询列表数据
		Map<String, Object> params = new HashMap<>();
    	params.put("page", page);
    	params.put("limit", limit);
		params.put("sidx", "play_order");
		params.put("order", "asc");
		params.put("themeId", themeId);
		
		Query query = new Query(params);
		List<ArticleEntity> articleList = articleService.queryList(query);
		
        return R.ok().put("data", articleList);
    }
}
