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
		changeAuctionStatus(id, AuctionStatus.OPEN);
	}

	public void announceClosed(long id) {
		changeAuctionStatus(id, AuctionStatus.CLOSE_LOST);
	}

	/**
	 * ��� ���� ����
	 * @param id	���ID
	 * @param status	�����ϰ��� �ϴ� ��� ����
	 */
	private void changeAuctionStatus(long id, AuctionStatus status) {
		Auction auction = this.auctionDao.findAuctionById(id);
		if (auction == null) throw new RuntimeException(id + "�� �ش��ϴ� ��������� �����ϴ�.");
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
