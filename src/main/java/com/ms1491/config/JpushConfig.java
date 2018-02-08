package com.ms1491.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;


/**
 * 极光通知配置
 * @author Administrator
 *
 */
@Configuration
public class JpushConfig {
    @Value("${jpush.appKey:#{null}}")
    private String appKey;
    @Value("${jpush.masterSecret:#{null}}")
    private String masterSecret;
	
    @Bean
	public JPushClient jPushClient(){
		return new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());
	}
}
