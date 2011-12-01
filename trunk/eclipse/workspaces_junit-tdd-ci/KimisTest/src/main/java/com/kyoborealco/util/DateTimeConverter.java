package com.kyoborealco.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��¥���� ��ȯ Class
 * @author ������
 * @since 2011-12-01
 */
public class DateTimeConverter {

	public final static String DATE_PATTERN = "yyyy-MM-dd";
	public final static String TIME_PATTERN = "HH:mm:ss";
	public final static String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

	/**
	 * ���ڿ�(��¥����)�� Date�������� ��ȯ
	 * �Է¿�) "2011-12-01 15:30:00"
	 * @param strDatetime ���ڿ�(��¥����)
	 * @return ��ȯ�� Date���İ�
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
	 * Date������ ���ڿ��������� ��ȯ
	 * @param dateTime ��ȯ�� Date
	 * @return ��ȯ�� String���İ�
	 */
	public static String datetimeToString(Date dateTime) {
		if ( dateTime == null ) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		return sdf.format(dateTime);
	}

}
