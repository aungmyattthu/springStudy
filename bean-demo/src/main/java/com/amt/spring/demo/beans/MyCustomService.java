package com.amt.spring.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class MyCustomService implements MyService{
	@Override
	public void doWork() {
		System.out.println("Custom Working is done");
	}
}
