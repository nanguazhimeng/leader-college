package com.ms1491;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ms1491.modules.api.redis.AppuserManagerRedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
	@Autowired
	AppuserManagerRedis appuserManagerRedis;
	
	
	@Test
	public void test(){
		
		String token = "bd4e08f4-06ce-4877-aa26-3fb404e994e5";
//		Map<String, Object> aa = appuserManagerRedis.getAllUserId();
//		if(aa!=null){
//			System.out.println(aa.containsKey(token));
//		}
	}
	
}
