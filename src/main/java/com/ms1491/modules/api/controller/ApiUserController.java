package com.ms1491.modules.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.R;
import com.ms1491.common.validator.Assert;
import com.ms1491.modules.api.annotation.AuthIgnore;
import com.ms1491.modules.api.annotation.SignIgnore;
import com.ms1491.modules.api.service.TokenService;
import com.ms1491.modules.api.service.UserService;
import com.ms1491.modules.sys.service.SysConfigService;

/**
 * API登录授权
 *
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api(value="登录接口")
public class ApiUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SysConfigService sysConfigService;
    /**
     * 登录
     */
    @SignIgnore
    @AuthIgnore
    @PostMapping("login")
    @ApiOperation(value="登录接口", notes="登录接口详细描述")
    public R login(String mobile, String password){
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        //用户登录
        long userId = userService.login(mobile, password);

        //生成token
        Map<String, Object> map = tokenService.createToken(userId);

        return R.ok(map);
    }
    /**
     * 获取闪屏页面图片
     */
    @AuthIgnore
    @GetMapping("getFlashImgs")
    @ApiOperation(value="获取闪屏页面图片", notes="获取闪屏页面图片")
    public R getImgs(){

    	String url = sysConfigService.getValue("FLASH_IMG");
    	String[] urls = url.split(",");

        return R.ok().put("data", urls);
    }
    

}
