package com.yunex.springrecipes.bookshop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookShopMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-bookshop.xml");
		BookShop bookShop = (BookShop)context.getBean("bookShop");
		bookShop.purchase("0001", "user1");
		
		System.out.println("¿Ï·á!");
	}

}

/*
-- DERBY

connect 'jdbc:derby://localhost:1527/bookshop;create=true';

CREATE TABLE BOOK ( ISBN VARCHAR(50) NOT NULL, BOOK_NAME VARCHAR(100) NOT NULL, PRICE INT, PRIMARY KEY (ISBN) );
CREATE TABLE BOOK_STOCK ( ISBN VARCHAR(50) NOT NULL, STOCK INT NOT NULL, PRIMARY KEY (ISBN), CHECK (STOCK >= 0) );
CREATE TABLE ACCOUNT ( USERNAME VARCHAR(50) NOT NULL, BALANCE INT NOT NULL, PRIMARY KEY ( USERNAME ), CHECK (BALANCE >= 0) );

INSERT INTO BOOK ( ISBN, BOOK_NAME, PRICE ) VALUES ( '0001', 'The First Book', 30 );
INSERT INTO BOOK_STOCK ( ISBN, STOCK ) VALUES ( '0001', 10 );
INSERT INTO ACCOUNT ( USERNAME, BALANCE ) VALUES ( 'user1', 20 );

*/
