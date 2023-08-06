package com.amt.test;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amt.practice.MyAppConfig;
import com.amt.practice.bean.HelloBean;

public class HelloIocContainerTest {

	@Test
	void demo() {
		try (var context = new AnnotationConfigApplicationContext(MyAppConfig.class)) {
//			context.scan("com.amt.practice.bean");
//			context.refresh();

			var bean = context.getBean(HelloBean.class);
			var date = context.getBean(Date.class);
			System.out.println(date);
			bean.greet();
			;
		}
	}
}
