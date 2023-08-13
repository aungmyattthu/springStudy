package com.amt.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ConversionDemo {
	ExpressionParser parser;

	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}

	@Test
	void test() {
		var expression = parser.parseExpression("'110 '");
		var result = expression.getValue(Integer.class);
		assertEquals(result, 110);
	}

}
