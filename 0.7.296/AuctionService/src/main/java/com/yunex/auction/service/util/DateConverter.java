package com.yunex.auction.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	
	public final static String DAY_PATTERN = "yyyy-MM-dd";
	public final static String TIME_PATTERN = "HH:mm";
	public final static String DAY_TIME_PATTERN = DAY_PATTERN + "+" + TIME_PATTERN;

	/**
	 * ��¥�� ���ڿ��� ��ȯ
	 * @param convertedDate
	 * @param pattern
	 * @return
	 */
	public static String convertIntoString(Date convertedDate, String pattern) {
		if ( convertedDate == null ) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(convertedDate);
	}
	
	/**
	 * ���ڿ� ��¥�� ���� ���·� ��ȯ
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date convertIntoDate(String dateStr, String pattern) {
		
		if ( dateStr == null ) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateStr);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
