package com.yunex.auction.service.impl.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yunex.auction.service.AuctionService;
import com.yunex.auction.service.dao.AuctionDao;
import com.yunex.auction.service.impl.AuctionServiceImpl;
import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.Item;

public class RegisterSellingAuctionTest {

	private AuctionService service;
	
	@Before
	public void setUp() throws Exception {
		this.service = new AuctionServiceImpl();
	}
	
	@After
	public void tearDown() throws Exception {
		this.service = null;
	}
	
	/**
	 * private 메소드에 대한 단위테스트
	 * @throws Exception
	 */
	@Test
	public void checkInvalidate() throws Exception {
		Method checkInvalidateMethod = AuctionServiceImpl.class.getDeclaredMethod("checkInvalidate", Auction.class);
		checkInvalidateMethod.setAccessible(true);
		
		Auction auction = new Auction(null);
		executeCheckInvalidateMethod(checkInvalidateMethod, auction);
		
		auction = new Auction(new Item("아이폰3", null, 0L));
		executeCheckInvalidateMethod(checkInvalidateMethod, auction);
		
		auction.setAuctionTitle("작년에 구매한 아이폰 팝니다.");
		executeCheckInvalidateMethod(checkInvalidateMethod, auction);

		auction.setOpenDate("2010-09-06", "18:30");
		executeCheckInvalidateMethod(checkInvalidateMethod, auction);

		auction.setClosingDate("2010-09-10", "22:30");
		executeCheckInvalidateMethod(checkInvalidateMethod, auction);

		auction.setBiddingClosingPrice(900000L);
		checkInvalidateMethod.invoke(this.service, auction);
	}

	private void executeCheckInvalidateMethod(Method checkInvalidateMethod,
			Auction auction) throws IllegalAccessException {
		try {
			checkInvalidateMethod.invoke(this.service, auction);
			fail();
		}
		catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof RuntimeException);
		}
	}
	
	@Test
	public void registerSellingAuction() throws Exception {
		Auction auction = makeAuction();
		
		fakeDao(auction);
		long id = this.service.registerSellingAuction(auction);
		assertTrue(id > 0L);
	}

	private AuctionDao fakeDao = EasyMock.createMock(AuctionDao.class);
	private void fakeDao(Auction auction) {
		EasyMock.expect(fakeDao.createAuctionAndItem(auction)).andReturn(1L);
		EasyMock.replay(fakeDao);
		((AuctionServiceImpl)this.service).setAuctionDao(fakeDao);
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
