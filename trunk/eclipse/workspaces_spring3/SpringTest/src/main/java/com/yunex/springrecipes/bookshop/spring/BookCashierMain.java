package com.yunex.springrecipes.bookshop.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookCashierMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-bookshop.xml");
		Cashier cashier = (Cashier)context.getBean("cashier");
		List<String> isbnList = Arrays.asList(new String[] { "0001", "0002" } );
		cashier.checkout(isbnList, "user2");
		
		System.out.println("¿Ï·á!");
	}

}

/*
-- DERBY

connect 'jdbc:derby://localhost:1527/bookshop;create=true';

CREATE TABLE BOOK ( ISBN VARCHAR(50) NOT NULL, BOOK_NAME VARCHAR(100) NOT NULL, PRICE INT, PRIMARY KEY (ISBN) );
CREATE TABLE BOOK_STOCK ( ISBN VARCHAR(50) NOT NULL, STOCK INT NOT NULL, PRIMARY KEY (ISBN), CHECK (STOCK >= 0) );
CREATE TABLE ACCOUNT ( USERNAME VARCHAR(50) NOT NULL, BALANCE INT NOT NULL, PRIMARY KEY ( USERNAME ), CHECK (BALANCE >= 0) );

INSERT INTO BOOK ( ISBN, BOOK_NAME, PRICE ) VALUES ( '0002', 'The Second Book', 50 );
INSERT INTO BOOK_STOCK ( ISBN, STOCK ) VALUES ( '0002', 10 );
INSERT INTO ACCOUNT ( USERNAME, BALANCE ) VALUES ( 'user2', 40 );

*/
