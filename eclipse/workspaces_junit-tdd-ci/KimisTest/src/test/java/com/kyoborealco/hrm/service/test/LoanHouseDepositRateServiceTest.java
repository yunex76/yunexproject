package com.kyoborealco.hrm.service.test;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import static org.easymock.EasyMock.*;
import org.junit.Test;

import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.hrm.service.LoanHouseDepositRateService;
import com.kyoborealco.util.DateTimeConverter;

/**
 * 전세자금대출이율 서비스 테스트 Class
 * @author 남윤혁
 * @since 2011-11-30
 */
public class LoanHouseDepositRateServiceTest {

	private LoanHouseDepositRateService fakeLoanHouseDepositRateService = EasyMock.createMock(LoanHouseDepositRateService.class);
	
	/**
	 * 전세자금대출이율 등록 테스트 Case
	 * @throws Exception
	 */
	@Test
	public void registerLoanHouseDepositRate() throws Exception {
		// 1. 중복 전세자금대출이율 존재여부 체크
		LoanHouseDepositRate loanHouseDepositRate = makeLoanHouseDepositRate();
		fackingLoanHouseDepositRateService(loanHouseDepositRate);
		
		boolean isDuplicate = fakeLoanHouseDepositRateService.isDuplicate(loanHouseDepositRate);
		assertEquals(false, isDuplicate);
		
		// 2. 전세자금대출이율 등록
		long loanHouseDepositRateId = fakeLoanHouseDepositRateService.registerLoanHouseDepositRate(loanHouseDepositRate);
		assertEquals(1L, loanHouseDepositRateId);
	}

	/**
	 * fake 처리 분리 
	 * @param loanHouseDepositRate
	 */
	private void fackingLoanHouseDepositRateService(
			LoanHouseDepositRate loanHouseDepositRate) {
		expect(fakeLoanHouseDepositRateService.isDuplicate(loanHouseDepositRate)).andReturn(false);
		expect(fakeLoanHouseDepositRateService.registerLoanHouseDepositRate(loanHouseDepositRate)).andReturn(1L);
		replay(fakeLoanHouseDepositRateService);
	}

	private LoanHouseDepositRate makeLoanHouseDepositRate() {
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

		return loanHouseDepositRate;
	}
}
