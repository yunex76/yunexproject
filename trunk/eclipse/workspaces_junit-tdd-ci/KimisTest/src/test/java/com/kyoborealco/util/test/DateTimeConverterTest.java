package com.kyoborealco.util.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.kyoborealco.util.DateTimeConverter;

/**
 * 날짜타입 변환 util 테스트 Class
 * @author 남윤혁
 * @since 2011-12-01
 */
public class DateTimeConverterTest {

	/**
	 * 문자열을 Date형태로 변환 Test case
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
		
		// null 값을 변환했을 때 처리 확인
		assertEquals( null, DateTimeConverter.stringToDatetime(null) );

		// 잘못된 날짜형식 값이 들어갔을때 처리 확인
		assertEquals( null, DateTimeConverter.stringToDatetime("2011-11-A1 12:12:12") );
	}
	
	/**
	 * Date형태를 문자열로 변환 Test case
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
		
		// null 값을 변환했을 때 처리 확인
		assertEquals( null, DateTimeConverter.datetimeToString(null) );
	}
}
