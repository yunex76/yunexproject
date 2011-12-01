package com.kyoborealco.hrm.entity.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.util.DateTimeConverter;

/**
 * 전세자금대출이율 entity 테스트 Class
 * @author 남윤혁
 * @since 2011-12-01
 */
public class LoanHouseDepositRateTest {

	@Test
	public void makeLoanHouseDepositRate() throws Exception {
		
		LoanHouseDepositRate loanHouseDepositRate = new LoanHouseDepositRate(
				1L,
				"20111201",
				"20131130",
				2.0d,
				8.5d,
				"DBA",
				DateTimeConverter.stringToDatetime("2011-12-01 15:55:00"),
				"DBA2",
				DateTimeConverter.stringToDatetime("2011-12-01 17:55:00")
			);

		assertNotNull(loanHouseDepositRate);
		assertInnerAttributes(loanHouseDepositRate);	// 내부속성값 점검
	}

	private void assertInnerAttributes(LoanHouseDepositRate loanHouseDepositRate) throws
		SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		ClassInnerAttributeCheck(loanHouseDepositRate, "id", (Long)1L);
		ClassInnerAttributeCheck(loanHouseDepositRate, "startUseDate", (String)"20111201");
		ClassInnerAttributeCheck(loanHouseDepositRate, "endUseDate", (String)"20131130");
		ClassInnerAttributeCheck(loanHouseDepositRate, "companyRate", (Double)2.0d);
		ClassInnerAttributeCheck(loanHouseDepositRate, "irsRate", (Double)8.5d);
		ClassInnerAttributeCheck(loanHouseDepositRate, "createUserId", (String)"DBA");
		ClassInnerAttributeCheck(loanHouseDepositRate, "createDateTime", (Date)DateTimeConverter.stringToDatetime("2011-12-01 15:55:00"));
		ClassInnerAttributeCheck(loanHouseDepositRate, "updateUserId", (String)"DBA2");
		ClassInnerAttributeCheck(loanHouseDepositRate, "updateDateTime", (Date)DateTimeConverter.stringToDatetime("2011-12-01 17:55:00"));
	}

	/**
	 * Class 내부의 속성 및 값체크
	 * @param object Class instance
	 * @param fieldName Class instance가 가진것으로 추정되는 멤버변수명
	 * @param checkValue Class instance가 가진 멤버변수가 담고 있다고 추정되는 값
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private void ClassInnerAttributeCheck(Object object,
			String fieldName, Object checkValue)
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		Field field = object.getClass().getDeclaredField(fieldName);
		if ( field == null ) {
			fail(object.getClass().getName() + " Class에 '" + fieldName + "' 속성이 없습니다.");
		}
		field.setAccessible(true);
		Object value = field.get(object);
		
		assertNotNull(value);
		assertEquals(checkValue.getClass(), value.getClass());

		assertEquals(checkValue, value);
	}
}
