package com.yunex.auction.service.obj;

import java.util.Date;

import com.yunex.auction.service.util.DateConverter;

public class Auction {

	private long id;
	private String auctionTitle;
	private Date openDate;
	private Date closingDate;
	private long biddingStartPrice;
	private long biddingIncrementPrice;
	private long biddingClosingPrice;
	private AuctionStatus status;
	
	private Item auctionItem;
	
	private final static String DAY_PATTERN = "yyyy-MM-dd";
	private final static String TIME_PATTERN = "HH:mm";		// "HH:mm:ss";
	private final static String DAY_TIME_PATTERN = DAY_PATTERN + " " + TIME_PATTERN;

	public Auction(Item item) {
		this.auctionItem = item;
	}

	public void setAuctionTitle(String auctionTitle) {
		this.auctionTitle = auctionTitle;
	}

	public void setBiddingStartPrice(long biddingStartPrice) {
		this.biddingStartPrice = biddingStartPrice;
	}

	public void setBiddingIncrementPrice(long biddingIncrementPrice) {
		this.biddingIncrementPrice = biddingIncrementPrice;
	}

	public void setBiddingClosingPrice(long biddingClosingPrice) {
		this.biddingClosingPrice = biddingClosingPrice;
	}

	public String getAuctionTitle() {
		return this.auctionTitle;
	}

	public long getBiddingStartPrice() {
		return biddingStartPrice;
	}

	public long getBiddingIncrementPrice() {
		return biddingIncrementPrice;
	}

	public long getBiddingClosingPrice() {
		return biddingClosingPrice;
	}

	public void setOpenDate(String openDay, String openTime) {
		this.openDate = DateConverter.convertIntoDate(openDay + " " + openTime, DAY_TIME_PATTERN);
	}

	public void setClosingDate(String closingDay, String closingTime) {
		this.closingDate = DateConverter.convertIntoDate(closingDay + " " + closingTime, DAY_TIME_PATTERN);
	}

	public String getOpenDay() {
		return DateConverter.convertIntoString(this.openDate, DAY_PATTERN);
	}

	public String getOpenTime() {
		return DateConverter.convertIntoString(this.openDate, TIME_PATTERN);
	}

	public Object getClosingDay() {
		return DateConverter.convertIntoString(this.closingDate, DAY_PATTERN);
	}

	public Object getClosingTime() {
		return DateConverter.convertIntoString(this.closingDate, TIME_PATTERN);
	}

	public Item getAuctionItem() {
		// TODO Auto-generated method stub
		return auctionItem;
	}

	public void setStatus(AuctionStatus open) {
		// TODO Auto-generated method stub
		
	}
	

}
