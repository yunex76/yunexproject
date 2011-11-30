package com.yunex.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start...");

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		SequenceGenerator generator = (SequenceGenerator)context.getBean("sequenceGenerator");
		
		// Map
		System.out.println("Map : " + generator.getSequence());
		System.out.println("Map : " + generator.getSequence());

		// Properties
		System.out.println("Properties : " + generator.getSequence2());
		System.out.println("Properties : " + generator.getSequence2());

		System.out.println("End...");
	}

}
