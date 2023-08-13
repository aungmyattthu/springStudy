package com.amt.aop.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.amt.aop.config.AppConfig;
import com.amt.aop.service.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class AspectJStyleTest {

	@Autowired
	MyService service;
	
	@Test
	void test() {
//		service.hello("aspectj", 10);
		service.divided(1, 0);
	}
}
        