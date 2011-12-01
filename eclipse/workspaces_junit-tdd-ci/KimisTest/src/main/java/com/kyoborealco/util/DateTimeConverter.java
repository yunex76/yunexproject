package com.kyoborealco.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 날짜형식 변환 Class
 * @author 남윤혁
 * @since 2011-12-01
 */
public class DateTimeConverter {

	public final static String DATE_PATTERN = "yyyy-MM-dd";
	public final static String TIME_PATTERN = "HH:mm:ss";
	public final static String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

	/**
	 * 문자열(날짜형식)을 Date형식으로 변환
	 * 입력예) "2011-12-01 15:30:00"
	 * @param strDatetime 문자열(날짜형식)
	 * @return 변환한 Date형식값
	 */
	public static Date stringToDatetime(String strDatetime) {
		if (strDatetime == null) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		try {
			return sdf.parse(strDatetime);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Date형식을 문자열형식으로 변환
	 * @param dateTime 변환할 Date
	 * @return 변환한 String형식값
	 */
	public static String datetimeToString(Date dateTime) {
		if ( dateTime == null ) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		return sdf.format(dateTime);
	}

}
