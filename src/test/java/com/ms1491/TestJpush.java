package com.ms1491;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ms1491.modules.api.utils.JpushUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpush {
	@Autowired
	JpushUtil jpushUtil;
	
	
	@Test
	public void test(){
		jpushUtil.pushNotifyToAll("111111111111", "222222222222");
//		Map<String, String> extras = new HashMap<String, String>();
//		extras.put("type", "1");
//		jpushUtil.pushNotify("11", "222", "r983363291", extras);
	}
	
}
