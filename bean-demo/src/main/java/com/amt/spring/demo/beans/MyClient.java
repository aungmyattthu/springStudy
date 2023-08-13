package com.amt.spring.demo.beans;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MyClient {
	
	/*
	 * @Autowired private Optional<MyService> service;
	 * 
	 * 
	 * 
	 * public void work() { service.orElse(new MyDefaultService()).doWork(); }
	 */
	@Autowired
	private MyService service;
	
	public void work() {
		service.doWork();
	}
}
