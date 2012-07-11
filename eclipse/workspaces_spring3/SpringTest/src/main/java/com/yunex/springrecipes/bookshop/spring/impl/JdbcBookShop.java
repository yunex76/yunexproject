package com.yunex.springrecipes.bookshop.spring.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.yunex.springrecipes.bookshop.spring.BookShop;

public class JdbcBookShop extends JdbcDaoSupport implements BookShop {

	@Override
	@Transactional
	public void purchase(String isbn, String username) {

		int price = getJdbcTemplate().queryForInt("SELECT PRICE FROM BOOK WHERE ISBN = ?", new Object[] { isbn });
		
		getJdbcTemplate().update(
				"UPDATE BOOK_STOCK SET STOCK = STOCK - 1 " +
				"WHERE ISBN = ?", new Object[] { isbn });
		
		getJdbcTemplate().update(
				"UPDATE ACCOUNT SET BALANCE = BALANCE - ? " +
				"WHERE USERNAME = ?", new Object[] { price, username });
	}
}
