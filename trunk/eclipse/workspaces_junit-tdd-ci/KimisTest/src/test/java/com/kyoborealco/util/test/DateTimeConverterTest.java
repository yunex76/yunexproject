package com.kyoborealco.util.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.kyoborealco.util.DateTimeConverter;

/**
 * ��¥Ÿ�� ��ȯ util �׽�Ʈ Class
 * @author ������
 * @since 2011-12-01
 */
public class DateTimeConverterTest {

	/**
	 * ���ڿ��� Date���·� ��ȯ Test case
	 */
	@Test
	public void convertStringToDatetime() throws Exception {

		Calendar cal = Calendar.getInstance();
		
		String s = String.format("%04d-%02d-%02d %02d:%02d:%02d",
			cal.get(Calendar.YEAR),
			(cal.get(Calendar.MONTH) + 1),
			cal.get(Calendar.DAY_OF_MONTH),
			
			cal.get(Calendar.HOUR_OF_DAY),
			cal.get(Calendar.MINUTE),
			cal.get(Calendar.SECOND)
		);
		
		assertEquals( cal.getTime().toString(), DateTimeConverter.stringToDatetime(s).toString() );
		
		// null ���� ��ȯ���� �� ó�� Ȯ��
		assertEquals( null, DateTimeConverter.stringToDatetime(null) );

		// �߸��� ��¥���� ���� ������ ó�� Ȯ��
		assertEquals( null, DateTimeConverter.stringToDatetime("2011-11-A1 12:12:12") );
	}
	
	/**
	 * Date���¸� ���ڿ��� ��ȯ Test case
	 */
	@Test
	public void convertDatetimeToString() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		
		String s = String.format("%04d-%02d-%02d %02d:%02d:%02d",
			cal.get(Calendar.YEAR),
			(cal.get(Calendar.MONTH) + 1),
			cal.get(Calendar.DAY_OF_MONTH),
			
			cal.get(Calendar.HOUR_OF_DAY),
			cal.get(Calendar.MINUTE),
			cal.get(Calendar.SECOND)
		);
		
		assertEquals( s, DateTimeConverter.datetimeToString(cal.getTime()) );
		
		// null ���� ��ȯ���� �� ó�� Ȯ��
		assertEquals( null, DateTimeConverter.datetimeToString(null) );
	}
}
