package com.amt.aop.service;

import org.springframework.stereotype.Component;

import com.amt.aop.dto.Result;

@Component
public class MyService {
	/*
	 * public void hello(String name, int count) {
	 * System.out.println("Hello from MyService"); }
	 */

	public Result hello(String name, int count) {
		System.out.println("Hello from MyService");
		return new Result(name, count);
	}
	
	public int divided(int a, int b) {
		return a/b;
	}
}
