package com.amt.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class HelloSpringExpression {
	ExpressionParser parser;
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void my_first_expression() {
//		var expressionStr = "10 + 5";
		
		var expression = parser.parseExpression("10+5");
		
		var result = expression.getValue(Integer.class);
		assertEquals(15, result);
	}
	@Test
	void using_generic_method() {
		var expression = parser.parseExpression("{1,2,3,4,5}");
		@SuppressWarnings("unchecked")
		var result = (List<Integer>)expression.getValue();
		assertNotNull(result);
		assertEquals(5, result.size());
	}
}
