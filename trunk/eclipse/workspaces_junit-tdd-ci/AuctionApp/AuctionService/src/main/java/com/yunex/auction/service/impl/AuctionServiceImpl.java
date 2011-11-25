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
		// ���ռ� üũ
		checkInvalidate(sellingAuction);
		// DB ����
		long id = this.auctionDao.createAuctionAndItem(sellingAuction);
		// ID ��ȯ
		return id;
	}

	/**
	 * ��� ������ ���� ���ռ� üũ
	 * @param sellingAuction
	 */
	private void checkInvalidate(Auction sellingAuction) {
		if (sellingAuction == null)
			throw new RuntimeException("��� ������ �����ϴ�.");
		if (sellingAuction.getAuctionItem() == null)
			throw new RuntimeException("��ǰ ������ �����ϴ�.");
		if (sellingAuction.getAuctionItem().getName() == null)
			throw new RuntimeException("��ǰ���� �����ϴ�.");
		
		if (sellingAuction.getAuctionTitle() == null)
			throw new RuntimeException("��� ������ �����ϴ�.");
		if (sellingAuction.getOpenDay() == null)
			throw new RuntimeException("��� �������� �����ϴ�.");
		if (sellingAuction.getClosingDay() == null)
			throw new RuntimeException("��� �������� �����ϴ�.");
		if (sellingAuction.getBiddingClosingPrice() == 0L)
			throw new RuntimeException("�������� �����ϴ�.");
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
