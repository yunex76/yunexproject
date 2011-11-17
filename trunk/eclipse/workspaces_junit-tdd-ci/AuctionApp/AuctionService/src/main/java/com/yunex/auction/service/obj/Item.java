package com.yunex.auction.service.obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yunex.auction.service.util.DateConverter;

public class Item {

	private String name;
	private Date purchasingDate;
	private long purchasingPrice;
	
	private final static String DATE_PATTERN = "yyyy-MM-dd";

	public Item(String name, String purchasingDate, long purchasingPrice) {
		this.name = name;
		this.purchasingPrice = purchasingPrice;
		this.purchasingDate = DateConverter.convertIntoDate(purchasingDate, DATE_PATTERN);
	}

	/**
	 * 구매일자
	 * @return
	 */
	public String getPurchasingDate() {
		return DateConverter.convertIntoString(this.purchasingDate, DATE_PATTERN);
	}

}
