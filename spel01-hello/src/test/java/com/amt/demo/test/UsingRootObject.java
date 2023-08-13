package com.amt.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.amt.demo.Address;
import com.amt.demo.Student;

public class UsingRootObject {
	private ExpressionParser parser;

	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}

	@Test
	void using_root_object() {
		var student = new Student("Aung Aung", 20, List.of("Java", "Spring", "Angular", "Flutter"));

		var expression = parser.parseExpression("name");
		var result = expression.getValue(student, String.class);
		assertEquals("Aung Aung", result);
		
		if(expression.isWritable(student)) {
			expression.setValue(student, "Mg Mg");
			
			result = expression.getValue(student, String.class);
			System.out.println("name is %s".formatted(result));
			assertEquals("Mg Mg", result);
		}

		expression = parser.parseExpression("age");
		var age = expression.getValue(student, Integer.class);
		assertEquals(20, age);

		expression = parser.parseExpression("interests[0]");
		var interest = expression.getValue(student, String.class);
		assertEquals("Java", interest);
	}

	@Test
	void using_record_root() {
		Address address = new Address("Lee Street","No.69","Sapa Township");
		var expression  = parser.parseExpression("street");
		var street = expression.getValue(address, String.class);
		assertEquals("Lee Street", street);
		
		expression  = parser.parseExpression("building");
		var buildingNo = expression.getValue(address, String.class);
		assertEquals("No.69", buildingNo);
		
		expression  = parser.parseExpression("township");
		var township = expression.getValue(address, String.class);
		assertEquals("Sapa Township", township);
	}
}
