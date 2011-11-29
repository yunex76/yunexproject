package com.yunex.auction.service.dao;

import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.AuctionStatus;

public interface AuctionDao {

	/**
	 * 경매와 물품을 저장
	 * @param sellingAuction
	 * @return
	 */
	public long createAuctionAndItem(Auction sellingAuction);

	public Auction findAuctionById(long l);

	public void updateAuction(Auction auction);

	public AuctionStatus findAuctionStatusById(long id);

}
