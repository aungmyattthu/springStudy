package com.amt.demo.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import com.amt.demo.Address;

public class EvaluationContextDemo {
	ExpressionParser parser;

	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}

	@Test
	void demo() {
		Address address = new Address("Ngalonelaphal Street", "No(83/84)", "Thanlyin");
		var expression = parser.parseExpression("building + ', ' + street + ', ' + township");
//		var context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().withRootObject(address).build();
//		var result = expression.getValue(context, address, String.class);
		var result = expression.getValue(context, String.class);
		System.out.println(result);
	}
}
