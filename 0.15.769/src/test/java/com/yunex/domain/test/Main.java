package com.yunex.domain.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yunex.springrecipes.sequence.SequenceGenerator;

public class Main {

	@Test
	public void test() {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		SequenceGenerator generator = (SequenceGenerator)context.getBean("sequenceGenerator");
		
		assertEquals(generator.getSequence(), "30100000A".toString());

	}

}
