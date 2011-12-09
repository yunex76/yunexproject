package com.kyoborealco.hrm.dao;

import com.kyoborealco.hrm.entity.LoanHouseDepositRate;

/**
 * 전세자금대출이율 DAO interface
 * @author 남윤혁
 * @since 2011-12-08
 */
public interface LoanHouseDepositRateDao {

	/**
	 * 전세자금대출이율 저장
	 * @param loanHouseDepositRate 
	 * @return
	 */
	long createLoanHouseDepositRate(LoanHouseDepositRate loanHouseDepositRate);

}
