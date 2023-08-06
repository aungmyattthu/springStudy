package com.amt.practice.bean;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	public void greet() {
		System.out.println("Hello IOC container");
	}
}
