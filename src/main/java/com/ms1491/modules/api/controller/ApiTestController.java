package com.ms1491.modules.api.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.annotation.ApiLog;
import com.ms1491.common.utils.R;
import com.ms1491.modules.api.annotation.AuthIgnore;
import com.ms1491.modules.api.annotation.LoginUser;
import com.ms1491.modules.api.annotation.SignIgnore;
import com.ms1491.modules.appuser.entity.AppUserEntity;

/**
 * API测试接口
 *
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api("测试接口")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @GetMapping("userInfo")
    @ApiOperation(value="获取用户信息接口", notes="获取用户信息详细描述")
    public R userInfo(@LoginUser AppUserEntity user){
        return R.ok().put("data", user);
    }

    /**
     * 忽略Token验证测试
     */
    @ApiLog
    @SignIgnore
    @AuthIgnore
    @GetMapping("notToken")
    @ApiOperation(value="忽略Token验证测试接口", notes="忽略Token验证测试详细描述")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }
    

//    /**
//     * 接收JSON数据
//     */
//    @PostMapping("jsonData")
//    @ApiOperation(value="接收JSON数据测试接口")
//    public R jsonData(@LoginUser UserEntity user, @RequestBody TokenEntity token){
//        return R.ok().put("user", user).put("token", token);
//    }
}
