package com.yunex.auction.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	/**
	 * ��¥�� ���ڿ��� ��ȯ
	 * @param convertedDate
	 * @param pattern
	 * @return
	 */
	public static String convertIntoString(Date convertedDate, String pattern) {
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
