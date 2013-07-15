package com.apress.springrecipes.post;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BackOfficeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-back.xml");
		
		BackOffice backOffice = (BackOffice)context.getBean("backOffice");
		Mail mail = backOffice.receiveMail();
		System.out.println("Mail #" + mail.getMailId() + " received");
	}

}
