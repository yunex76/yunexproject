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
		
		// 1. 경매 등록
		Auction sellingAuction = makeAuction();
		fakingAuctionService(sellingAuction);
		
		long registerdAuctionId = fakeAuctionService.registerSellingAuction(sellingAuction);
		assertEquals(1L, registerdAuctionId);
		assertRegisteredSellingItem(registerdAuctionId);	// 경매 물품 조회 점검
		
		// 2. 경매 시작
		fakeAuctionService.startBidding(registerdAuctionId);
		assertAuctionBiddings(registerdAuctionId);
		
		// 3. 경매 종료
		fakeAuctionService.announceClosed(registerdAuctionId);
		assertOnAuctionList(registerdAuctionId);	// 진행 경매 목록 점검
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
		Auction auction = new Auction(new Item("아이폰4S", "2011-11-11", 800000L));
		
		auction.setAuctionTitle("한달전 구매한 아이폰 판매합니다.");
		auction.setOpenDate("2011-11-14", "00:00");
		auction.setClosingDate("2011-11-18", "23:59");
		auction.setBiddingStartPrice(500000L);
		auction.setBiddingIncrementPrice(10000L);
		auction.setBiddingClosingPrice(800000L);
		
		return auction;
	}

	/**
	 * 경매 물품 조회 점검
	 */
	private void assertRegisteredSellingItem(long auctionId) {
		Auction sellingAuction = fakeAuctionService.findSellingItemById(auctionId);
		assertNotNull(sellingAuction);	// <- 오류 없애려면 " import static org.junit.Assert.*; " 추가
	}
}
