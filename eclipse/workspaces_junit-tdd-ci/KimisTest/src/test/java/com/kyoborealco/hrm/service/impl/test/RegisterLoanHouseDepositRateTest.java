package com.kyoborealco.hrm.service.impl.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kyoborealco.hrm.dao.LoanHouseDepositRateDao;
import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.hrm.service.LoanHouseDepositRateService;
import com.kyoborealco.hrm.service.impl.LoanHouseDepositRateServiceImpl;
import com.kyoborealco.util.DateTimeConverter;

public class RegisterLoanHouseDepositRateTest {

	private LoanHouseDepositRateService service;
	
	@Before
	public void setUp() throws Exception {
		this.service = new LoanHouseDepositRateServiceImpl();
	}
	
	@After
	public void tearDown() throws Exception {
		this.service = null;
	}
	
	@Test
	public void registerLoanHouseDepositRate() throws Exception {
		LoanHouseDepositRate loanHouseDepositRate = makeLoanHouseDepositRate();
		
		fakeDao(loanHouseDepositRate);
		long id = this.service.registerLoanHouseDepositRate(loanHouseDepositRate);
		assertTrue(id > 0L);
	}
	
	private LoanHouseDepositRateDao loanHouseDepositRateDao = EasyMock.createMock(LoanHouseDepositRateDao.class);	
	private void fakeDao(LoanHouseDepositRate loanHouseDepositRate) {
		EasyMock.expect(loanHouseDepositRateDao.createLoanHouseDepositRate(loanHouseDepositRate)).andReturn(1L);
		EasyMock.replay(loanHouseDepositRateDao);
		((LoanHouseDepositRateServiceImpl)this.service).setLoanHouseDepositRateDao(loanHouseDepositRateDao);
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
	
	/**
	 * private 메소드에 대한 테스트
	 * @throws Exception
	 */
	@Test
	public void checkInvalidate() throws Exception {
		Method checkInvalidateMethod = LoanHouseDepositRateServiceImpl.class.getDeclaredMethod("checkInvalidate", LoanHouseDepositRate.class);
		checkInvalidateMethod.setAccessible(true);
		
		LoanHouseDepositRate loanHouseDepositRate = new LoanHouseDepositRate();
		executeCheckInvalidateMethod(checkInvalidateMethod,
				loanHouseDepositRate);
		
		loanHouseDepositRate = new LoanHouseDepositRate(
				1L, null, "20131130", 2.0d, 8.5d, "DBA", DateTimeConverter.stringToDatetime("2011-12-01 15:55:00"),
				"DBA2", DateTimeConverter.stringToDatetime("2011-12-01 17:55:00")
			);
		executeCheckInvalidateMethod(checkInvalidateMethod,
				loanHouseDepositRate);
		
		loanHouseDepositRate.setStartUseDate("20111201");
		checkInvalidateMethod.invoke(this.service, loanHouseDepositRate);
	}

	private void executeCheckInvalidateMethod(Method checkInvalidateMethod,
			LoanHouseDepositRate loanHouseDepositRate)
			throws IllegalAccessException {
		try {
			checkInvalidateMethod.invoke(this.service, loanHouseDepositRate);
			fail();
		}
		catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof RuntimeException);
		}
	}

}
