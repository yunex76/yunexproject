package com.yunex.auction.service.impl;

import java.util.List;

import com.yunex.auction.service.AuctionService;
import com.yunex.auction.service.dao.AuctionDao;
import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.AuctionStatus;

public class AuctionServiceImpl implements AuctionService {

	private AuctionDao auctionDao;

	public void setAuctionDao(AuctionDao auctionDao) {
		this.auctionDao = auctionDao;
	}
	
	public long registerSellingAuction(Auction sellingAuction) {
		// 정합성 체크
		checkInvalidate(sellingAuction);
		// DB 저장
		long id = this.auctionDao.createAuctionAndItem(sellingAuction);
		// ID 반환
		return id;
	}

	/**
	 * 경매 정보에 대한 정합성 체크
	 * @param sellingAuction
	 */
	private void checkInvalidate(Auction sellingAuction) {
		if (sellingAuction == null)
			throw new RuntimeException("경매 정보가 없습니다.");
		if (sellingAuction.getAuctionItem() == null)
			throw new RuntimeException("물품 정보가 없습니다.");
		if (sellingAuction.getAuctionItem().getName() == null)
			throw new RuntimeException("물품명이 없습니다.");
		
		if (sellingAuction.getAuctionTitle() == null)
			throw new RuntimeException("경매 제목이 없습니다.");
		if (sellingAuction.getOpenDay() == null)
			throw new RuntimeException("경매 시작일이 없습니다.");
		if (sellingAuction.getClosingDay() == null)
			throw new RuntimeException("경매 종료일이 없습니다.");
		if (sellingAuction.getBiddingClosingPrice() == 0L)
			throw new RuntimeException("낙찰가가 없습니다.");
	}

	public void startBidding(long id) {
		// TODO Auto-generated method stub

	}

	public void announceClosed(long id) {
		// TODO Auto-generated method stub

	}

	public Auction findSellingAuctionById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public AuctionStatus findAuctionStatusById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Auction> findOngoingAuction() {
		// TODO Auto-generated method stub
		return null;
	}

}
