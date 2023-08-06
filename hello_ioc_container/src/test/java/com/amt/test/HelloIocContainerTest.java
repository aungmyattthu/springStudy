package com.amt.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amt.practice.bean.HelloBean;
public class HelloIocContainerTest {
	
	@Test
	void demo() {
		try(var context = new AnnotationConfigApplicationContext()){
			context.scan("com.amt.practice.bean");
			context.refresh();
			
			var bean = context.getBean(HelloBean.class );
			bean.greet();
;		}
	}
}
