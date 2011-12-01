package com.kyoborealco.hrm.service.test;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import static org.easymock.EasyMock.*;
import org.junit.Test;

import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.hrm.service.LoanHouseDepositRateService;

/**
 * �����ڱݴ������� ���� �׽�Ʈ Class
 * @author ������
 * @since 2011-11-30
 */
public class LoanHouseDepositRateServiceTest {

	private LoanHouseDepositRateService fakeLoanHouseDepositRateService = EasyMock.createMock(LoanHouseDepositRateService.class);
	
	/**
	 * �����ڱݴ������� ��� �׽�Ʈ Case
	 * @throws Exception
	 */
	@Test
	public void registerLoanHouseDepositRate() throws Exception {
		// 1. �ߺ� �����ڱݴ������� ���翩�� üũ
		LoanHouseDepositRate loanHouseDepositRate = makeLoanHouseDepositRate();
		fackingLoanHouseDepositRateService(loanHouseDepositRate);
		boolean isDuplicate = fakeLoanHouseDepositRateService.isDuplicate(loanHouseDepositRate);
		assertEquals(false, isDuplicate);
		
		// 2. �����ڱݴ������� ���
		long loanHouseDepositRateId = fakeLoanHouseDepositRateService.registerLoanHouseDepositRate(loanHouseDepositRate);
		assertEquals(1L, loanHouseDepositRateId);
	}

	/**
	 * fake ó�� �и� 
	 * @param loanHouseDepositRate
	 */
	private void fackingLoanHouseDepositRateService(
			LoanHouseDepositRate loanHouseDepositRate) {
		expect(fakeLoanHouseDepositRateService.isDuplicate(loanHouseDepositRate)).andReturn(false);
		expect(fakeLoanHouseDepositRateService.registerLoanHouseDepositRate(loanHouseDepositRate)).andReturn(1L);
		replay(fakeLoanHouseDepositRateService);
	}

	private LoanHouseDepositRate makeLoanHouseDepositRate() {
		return null;
	}
}
