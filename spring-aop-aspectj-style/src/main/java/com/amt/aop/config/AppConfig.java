package com.amt.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
		"com.amt.aop.service",
		"com.amt.aop.aspects"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
