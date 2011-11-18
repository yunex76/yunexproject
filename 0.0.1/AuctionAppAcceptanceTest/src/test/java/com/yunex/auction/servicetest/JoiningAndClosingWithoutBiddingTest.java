package com.yunex.auction.servicetest;

import org.junit.Test;
import static org.junit.Assert.*;

import org.easymock.EasyMock;
import static org.easymock.EasyMock.*;

import com.yunex.auction.*;
import com.yunex.auction.service.AuctionService;
import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.AuctionStatus;
import com.yunex.auction.service.obj.Item;

public class JoiningAndClosingWithoutBiddingTest {

	private AuctionService fakeAuctionService = EasyMock.createMock(AuctionService.class);
	
	@Test
	public void joiningAndClosingWithoutBidding() throws Exception {
		
		// 1. ��� ���
		Auction sellingAuction = makeAuction();
		fakingAuctionService(sellingAuction);
		
		long registerdAuctionId = fakeAuctionService.registerSellingAuction(sellingAuction);
		assertEquals(1L, registerdAuctionId);
		assertRegisteredSellingItem(registerdAuctionId);	// ��� ��ǰ ��ȸ ����
		
		// 2. ��� ����
		fakeAuctionService.startBidding(registerdAuctionId);
		assertAuctionBiddings(registerdAuctionId);
		
		// 3. ��� ����
		fakeAuctionService.announceClosed(registerdAuctionId);
		assertOnAuctionList(registerdAuctionId);	// ���� ��� ��� ����
	}

	private void assertOnAuctionList(long auctionId) {
		AuctionStatus status = fakeAuctionService.findAuctionStatusById(auctionId);
		assertEquals(AuctionStatus.CLOSE_LOST, status);
	}

	private void assertAuctionBiddings(long auctionId) {
		AuctionStatus status = fakeAuctionService.findAuctionStatusById(auctionId);
		assertEquals(AuctionStatus.OPEN, status);
	}

	private void fakingAuctionService(Auction sellingAuction) {
		expect(fakeAuctionService.registerSellingAuction(sellingAuction)).andReturn(1L);
		expect(fakeAuctionService.findSellingItemById(1L)).andReturn(sellingAuction);
		
		expect(fakeAuctionService.findAuctionStatusById(1L)).andReturn(AuctionStatus.OPEN);
		fakeAuctionService.startBidding(1L);
		EasyMock.expectLastCall();
		
		expect(fakeAuctionService.findAuctionStatusById(1L)).andReturn(AuctionStatus.CLOSE_LOST);
		fakeAuctionService.announceClosed(1L);
		EasyMock.expectLastCall();
		
		replay(fakeAuctionService);
	}

	private Auction makeAuction() {
		Auction auction = new Auction(new Item("������4S", "2011-11-11", 800000L));
		
		auction.setAuctionTitle("�Ѵ��� ������ ������ �Ǹ��մϴ�.");
		auction.setOpenDate("2011-11-14", "00:00");
		auction.setClosingDate("2011-11-18", "23:59");
		auction.setBiddingStartPrice(500000L);
		auction.setBiddingIncrementPrice(10000L);
		auction.setBiddingClosingPrice(800000L);
		
		return auction;
	}

	/**
	 * ��� ��ǰ ��ȸ ����
	 */
	private void assertRegisteredSellingItem(long auctionId) {
		Auction sellingAuction = fakeAuctionService.findSellingItemById(auctionId);
		assertNotNull(sellingAuction);	// <- ���� ���ַ��� " import static org.junit.Assert.*; " �߰�
	}
}
