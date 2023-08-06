package com.amt.practice;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.amt.practice")
public class MyAppConfig {

//	@Bean
//	HelloBean helloBean() {
//		return new HelloBean();
//	}

	@Bean
	Date currentDate() {
		return new Date();
	}
}
