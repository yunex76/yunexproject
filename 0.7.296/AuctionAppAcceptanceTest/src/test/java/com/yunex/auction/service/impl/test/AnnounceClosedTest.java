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
import com.yunex.auction.service.obj.AuctionStatus;

public class AnnounceClosedTest {

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
	public void announceClosed() throws Exception {

		EasyMock.expect(fakeDao.findAuctionById(5L)).andReturn(null);
		Auction auction = AuctionMaker.make();
		EasyMock.expect(fakeDao.findAuctionById(1L)).andReturn(auction);
		fakeDao.updateAuction(auction);
		EasyMock.expectLastCall();
		
		EasyMock.expect(fakeDao.findAuctionStatusById(1L)).andReturn(AuctionStatus.CLOSE_LOST);
		EasyMock.replay(fakeDao);
		((AuctionServiceImpl)this.service).setAuctionDao(fakeDao);
		
		try {
			this.service.announceClosed(5L);
		}
		catch (RuntimeException e) {
			assertTrue(true);
		}
		
		this.service.announceClosed(1L);
		assertEquals(AuctionStatus.CLOSE_LOST, this.service.findAuctionStatusById(1L));
	}
}
