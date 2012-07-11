package com.yunex.springrecipes.bookshop.spring.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yunex.springrecipes.bookshop.spring.BookShop;
import com.yunex.springrecipes.bookshop.spring.Cashier;

public class BookShopCashier implements Cashier {

	private BookShop bookShop;
	
	public void setBookShop(BookShop bookShop) {
		this.bookShop = bookShop;
	}
	
	@Override
	@Transactional
	public void checkout(List<String> isbns, String username) {

		for (String isbn : isbns) {
			bookShop.purchase(isbn, username);
		}
	}

}
