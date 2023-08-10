package com.amt.spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amt.spring.demo.beans.MyClient;
import com.amt.spring.demo.beans.MyCustomService;
import com.amt.spring.demo.beans.MyService;

@Configuration
public class AppConfig {
	@Bean
	MyClient myClient() {
		return new MyClient();
	}
	@Bean
	MyService myService() {
		return new MyCustomService();
	}
}
