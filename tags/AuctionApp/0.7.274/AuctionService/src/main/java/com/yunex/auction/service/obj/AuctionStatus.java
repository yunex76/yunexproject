package com.yunex.auction.service.obj;

public enum AuctionStatus {
	NOT_OPEN,		// 시작이전
	OPEN,			// 시작
	CLOSE_LOST,		// 낙찰자없이 마감
	CLOSE_WON		// 낙찰자 존재하여 마감
}
