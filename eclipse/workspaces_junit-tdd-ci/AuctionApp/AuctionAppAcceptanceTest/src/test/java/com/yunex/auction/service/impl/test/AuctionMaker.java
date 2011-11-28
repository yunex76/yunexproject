package com.yunex.auction.service.impl.test;

import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.Item;

public class AuctionMaker {

	public static Auction make() {
		Auction auction = new Auction(new Item("������3", "2009-12-21", 900000L));
		
		auction.setAuctionTitle("�۳⿡ ������ ������ �Ǹ��մϴ�.");
		auction.setOpenDate("2010-09-06", "18:30");
		auction.setClosingDate("2010-09-10", "22:30");
		auction.setBiddingStartPrice(500000L);
		auction.setBiddingIncrementPrice(10000L);
		auction.setBiddingClosingPrice(800000L);
		return auction;
	}

}
