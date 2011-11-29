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
		changeAuctionStatus(id, AuctionStatus.OPEN);
	}

	public void announceClosed(long id) {
		changeAuctionStatus(id, AuctionStatus.CLOSE_LOST);
	}

	/**
	 * 경매 상태 변경
	 * @param id	경매ID
	 * @param status	변경하고자 하는 경매 상태
	 */
	private void changeAuctionStatus(long id, AuctionStatus status) {
		Auction auction = this.auctionDao.findAuctionById(id);
		if (auction == null) throw new RuntimeException(id + "에 해당하는 경매정보가 없습니다.");
		auction.setStatus(status);
		this.auctionDao.updateAuction(auction);
	}

	public Auction findSellingAuctionById(long id) {
		return this.auctionDao.findAuctionById(id);
	}

	public AuctionStatus findAuctionStatusById(long id) {
		return this.auctionDao.findAuctionStatusById(id);
	}

	public List<Auction> findOngoingAuction() {
		// TODO Auto-generated method stub
		return null;
	}

}
