package com.kyoborealco.hrm.dao.impl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kyoborealco.hrm.dao.LoanHouseDepositRateDao;
import com.kyoborealco.hrm.dao.impl.LoanHouseDepositRateDaoImpl;
import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.util.DateTimeConverter;

public class LoanHouseDepositRateDaoImplTest {

	private LoanHouseDepositRateDao dao;
	
	@Before
	public void setUp() throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-jpa.xml");
		dao = (LoanHouseDepositRateDao) context.getBean("loanHouseDepositRateDao");
	}
	
	@Test
	public void createLoanHouseDepositRate() {
		LoanHouseDepositRate loanHouseDepositRate = new LoanHouseDepositRate(
				0L,
				"20111201",
				"20131130",
				2.0d,
				8.5d,
				"DBA",
				new Date(),
				null,
				null
			);
		
		long id = dao.createLoanHouseDepositRate(loanHouseDepositRate);
		System.out.println(id);
		assertTrue(id > 0L);
	}
	
}
