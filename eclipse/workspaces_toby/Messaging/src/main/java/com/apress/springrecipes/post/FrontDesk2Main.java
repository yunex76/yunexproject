package com.apress.springrecipes.post;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FrontDesk2Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-front2.xml");
		
		FrontDesk frontDesk = (FrontDesk)context.getBean("frontDesk2");
		frontDesk.sendMail(new Mail("1234", "US", 1.5));
		System.out.println("전송성공!");
	}

}
