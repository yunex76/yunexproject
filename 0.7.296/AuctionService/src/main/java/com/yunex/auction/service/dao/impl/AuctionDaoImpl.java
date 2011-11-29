package com.yunex.auction.service.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yunex.auction.service.dao.AuctionDao;
import com.yunex.auction.service.obj.Auction;
import com.yunex.auction.service.obj.AuctionStatus;

public class AuctionDaoImpl implements AuctionDao {
	
	private SqlMapClient client;
	
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	public long createAuctionAndItem(Auction sellingAuction) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Auction findAuctionById(long l) {
		try {
			return (Auction)this.client.queryForObject("selectAuctionById", l);
		}
		catch (SQLException e) {
			throw new RuntimeException("경매 조회중 오류 발생", e);
		}
	}

	public void updateAuction(Auction auction) {
		// TODO Auto-generated method stub

	}

	public AuctionStatus findAuctionStatusById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
