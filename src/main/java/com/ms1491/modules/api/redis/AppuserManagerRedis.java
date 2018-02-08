package com.ms1491.modules.api.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms1491.common.utils.RedisKeys;
import com.ms1491.common.utils.RedisUtils;

/**
 * 系统配置Redis
 *
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017/7/18 21:08
 */
@Component
public class AppuserManagerRedis {
	
    @Autowired
    private RedisUtils redisUtils;
    
	public String getUserIdByToken(String token) {
		String key = RedisKeys.getTokenKey(token);
		return redisUtils.hget(key,"userId");
	}
	
	public boolean executeIsTokenExsist(String token){
		String key = RedisKeys.getTokenKey(token);
		return redisUtils.hasKey(key);
	}
}
