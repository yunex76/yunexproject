package com.yunex.auction.service;

import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.AuctionStatus;

public interface AuctionService {

	/**
	 * ��� ���
	 * @param sellingAuction TODO
	 */
	long registerSellingAuction(Auction sellingAuction);
	
	/**
	 * ��� ����
	 * @param id 
	 */
	void startBidding(long id);

	/**
	 * ��� ����
	 * @param id 
	 */
	void announceClosed(long id);

	/**
	 * ��ϵ� ��� ��ȸ
	 * @param id ���ID
	 * @return ���
	 */
	Auction findSellingItemById(long id);

	/**
	 * ��� ���°� ��ȸ
	 * @param id ���ID
	 * @return ��� ���°�
	 */
	AuctionStatus findAuctionStatusById(long id);

}
