package com.amt.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import com.amt.aop.dto.Result;

@Aspect
@Configuration
public class MyConcern {
	@Pointcut("bean(myService)")
	void myServiceBean() {

	}

	@Before(value = "bean(myService) && args(value,..)", argNames = "value")
	void beforeLog(String value) {
		System.out.println("before Execution");
		System.out.println("value is %s".formatted(value));
	}

	@AfterReturning(pointcut = "bean(myService) " + "&& execution(com.amt..Result *(..))"
			+ "&& args(name,count)", argNames = "result, name, count", returning = "result")
	void afterReturning(Result result, String name, int count) {
		System.out.println("after returning");
		System.out.println("return ");
		System.out.println("============================================");
		System.out.println(" name: %s".formatted(result.name()));
		System.out.println(" count: %d".formatted(result.count()));
		System.out.println("============================================");
		System.out.println("arguments ");
		System.out.println(" name: %s".formatted(name));
		System.out.println(" count: %d".formatted(count));
	}

	@AfterThrowing(pointcut = "bean(myService) && args(a,b)",
			throwing = "ex",
			argNames = "ex,a,b")
	void afterThrowing(RuntimeException ex, int a, int b) {
		System.out.println("after Throwing");
		System.out.println("============================================");
		System.out.println(ex.getClass().getName());
		System.out.println(ex.getMessage());
		System.out.println("args a : %d".formatted(a));
		System.out.println("args b : %d".formatted(b));
		System.out.println("============================================");
	}

	@After(value = "bean(myService) && args(..,count)", argNames = "count")
	void afterAll(int count) {
		System.out.println("after finally");
		System.out.println("after finally|| count is %d".formatted(count));
	}

	@Around(value = "bean(myService) && args(value,count)", argNames = "value, count")
	Object aroungInvoke(ProceedingJoinPoint jointPoint, String value, int count) {
		Object result = null;
		System.out.println("around before invoke");

		System.out.println("Value is %s".formatted(value));
		System.out.println("count is %d".formatted(count));
		try {
			result = jointPoint.proceed();
			System.out.println("around after returning");
		} catch (Throwable e) {
			System.out.println("around after throwing");
			throw new RuntimeException(e);
		} finally {
			System.out.println("around after finally");
		}
		return result;
	}
}
