package com.kyoborealco.hrm.entity.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.util.DateTimeConverter;
import com.kyoborealco.util.test.ClassInnerAttributeCheck;

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

	/**
	 * 내부속성값 점검
	 * @param loanHouseDepositRate
	 * @throws Exception
	 */
	private void assertInnerAttributes(LoanHouseDepositRate loanHouseDepositRate) throws Exception {
		
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "id", (Long)1L));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "startUseDate", (String)"20111201"));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "endUseDate", (String)"20131130"));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "companyRate", (Double)2.0d));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "irsRate", (Double)8.5d));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "createUserId", (String)"DBA"));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "createDateTime", (Date)DateTimeConverter.stringToDatetime("2011-12-01 15:55:00")));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "updateUserId", (String)"DBA2"));
		assertTrue(ClassInnerAttributeCheck.check(loanHouseDepositRate, "updateDateTime", (Date)DateTimeConverter.stringToDatetime("2011-12-01 17:55:00")));
	}

}
