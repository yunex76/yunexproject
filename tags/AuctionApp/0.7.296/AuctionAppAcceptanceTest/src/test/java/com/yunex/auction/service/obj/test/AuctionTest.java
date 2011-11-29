package com.yunex.auction.service.obj.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.Item;

public class AuctionTest {

	@Test
	public void makeAuction() throws Exception {
		Auction auction = new Auction(new Item("아이폰4S", "2011-11-11", 800000L));
		
		auction.setAuctionTitle("한달전 구매한 아이폰 판매합니다.");
		auction.setOpenDate("2011-11-14", "00:00");
		auction.setClosingDate("2011-11-18", "23:59");
		auction.setBiddingStartPrice(500000L);
		auction.setBiddingIncrementPrice(10000L);
		auction.setBiddingClosingPrice(800000L);
		
		assertEquals("한달전 구매한 아이폰 판매합니다.", auction.getAuctionTitle());
		
		assertEquals("2011-11-14", auction.getOpenDay());
		assertEquals("00:00", auction.getOpenTime());
		assertEquals("2011-11-18", auction.getClosingDay());
		assertEquals("23:59", auction.getClosingTime());
		
		assertEquals(500000L, auction.getBiddingStartPrice());
		assertEquals(10000L, auction.getBiddingIncrementPrice());
		assertEquals(800000L, auction.getBiddingClosingPrice());
		
	}
}
