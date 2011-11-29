package com.yunex.auction.service.dao.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.yunex.auction.service.dao.AuctionDao;
import com.yunex.auction.service.dao.impl.AuctionDaoImpl;
import com.yunex.auction.service.obj.Auction;

public class FindAuctionByIdTest {

	private AuctionDao auctionDao;
	
	private final static String RESOURCE = "sqlmap-config.xml";
	
	@Before 
	public void setUp() throws Exception {
		this.auctionDao = new AuctionDaoImpl();
		initDbTest();
	}
	
	private final static String CREATE_AUCTION = "CREATE TABLE TB_AUCTION ("
			+ "id BIGINT PRIMARY KEY,"
			+ "title VARCHAR(200) NOT NULL,"
			+ "open_date DATETIME NOT NULL,"
			+ "closing_date DATETIME NOT NULL,"
			+ "bid_start_price BIGINT,"
			+ "bid_incr_price BIGINT,"
			+ "bid_close_price BIGINT,"
			+ "status VARCHAR(10));";
	
	private void initDbTest() throws Exception {
		// iBATIS SQL Map Client 주입
		Reader reader = Resources.getResourceAsReader(RESOURCE);
		SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(reader);
		((AuctionDaoImpl)this.auctionDao).setClient(client);
		
		Connection conn = client.getDataSource().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(CREATE_AUCTION);
		pstmt.execute();
		
		// insert sql
		String sqlInsert = "";
		sqlInsert += "INSERT INTO TB_AUCTION VALUES (1, '작년에 구매한 아이폰 팝니다.', ";
		sqlInsert += "'2010-09-06 18:30:00.000', '2010-09-10 22:30:00.000', ";
		sqlInsert += "500000, 10000, 800000, 'NOT_OPEN')";

		pstmt = conn.prepareStatement(sqlInsert);
		pstmt.execute();
		pstmt.close();
	}

	@After
	public void tearDown() throws Exception {
		this.auctionDao = null;
	}
	
	@Test
	public void findAuctionById() throws Exception {
		Auction auction = this.auctionDao.findAuctionById(1L);
		assertNotNull(auction);
		
		assertEquals(1L, auction.getId());
		assertEquals("작년에 구매한 아이폰 팝니다.", auction.getAuctionTitle());
		assertEquals("2010-09-06", auction.getOpenDay());
		assertEquals("18:30", auction.getOpenTime());
		assertEquals("2010-09-10", auction.getClosingDay());
		assertEquals("22:30", auction.getClosingTime());
		
		assertEquals(500000L, auction.getBiddingStartPrice());
		assertEquals(10000L, auction.getBiddingIncrementPrice());
		assertEquals(800000L, auction.getBiddingClosingPrice());
	}
	
}
