package com.yunex.auction.service;

import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.AuctionStatus;

public interface AuctionService {

	/**
	 * 경매 등록
	 * @param sellingAuction TODO
	 */
	long registerSellingAuction(Auction sellingAuction);
	
	/**
	 * 경매 시작
	 * @param id 
	 */
	void startBidding(long id);

	/**
	 * 경매 종료
	 * @param id 
	 */
	void announceClosed(long id);

	/**
	 * 등록된 경매 조회
	 * @param id 경매ID
	 * @return 경매
	 */
	Auction findSellingItemById(long id);

	/**
	 * 경매 상태값 조회
	 * @param id 경매ID
	 * @return 경매 상태값
	 */
	AuctionStatus findAuctionStatusById(long id);

}
