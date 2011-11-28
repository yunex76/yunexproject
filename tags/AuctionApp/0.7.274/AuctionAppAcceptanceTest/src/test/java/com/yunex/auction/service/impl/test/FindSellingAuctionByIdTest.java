package com.yunex.auction.service.impl.test;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yunex.auction.service.AuctionService;
import com.yunex.auction.service.dao.AuctionDao;
import com.yunex.auction.service.impl.AuctionServiceImpl;
import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.Item;

public class FindSellingAuctionByIdTest {

	private AuctionService service;
	
	@Before
	public void setUp() throws Exception {
		this.service = new AuctionServiceImpl();
	}
	
	@After
	public void tearDown() throws Exception {
		this.service = null;
	}
	
	private AuctionDao fakeDao = EasyMock.createMock(AuctionDao.class);
	
	@Test
	public void findSellingAuctionById() throws Exception {
		EasyMock.expect(fakeDao.findAuctionById(6L)).andReturn(null);
		EasyMock.expect(fakeDao.findAuctionById(1L)).andReturn(makeAuction());
		EasyMock.replay(fakeDao);
		((AuctionServiceImpl)this.service).setAuctionDao(fakeDao);
		
		Auction auction = this.service.findSellingAuctionById(6L);
		assertNull(auction);
		
		auction = this.service.findSellingAuctionById(1L);
		assertNotNull(auction);
	}

	private Auction makeAuction() {
		Auction auction = new Auction(new Item("아이폰3", "2009-12-21", 900000L));
		
		auction.setAuctionTitle("작년에 구매한 아이폰 판매합니다.");
		auction.setOpenDate("2010-09-06", "18:30");
		auction.setClosingDate("2010-09-10", "22:30");
		auction.setBiddingStartPrice(500000L);
		auction.setBiddingIncrementPrice(10000L);
		auction.setBiddingClosingPrice(800000L);
		return auction;
	}
}
