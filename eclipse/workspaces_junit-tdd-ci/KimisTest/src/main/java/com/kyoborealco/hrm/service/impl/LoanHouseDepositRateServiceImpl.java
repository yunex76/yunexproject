package com.kyoborealco.hrm.service.impl;

import com.kyoborealco.hrm.dao.LoanHouseDepositRateDao;
import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.hrm.service.LoanHouseDepositRateService;

/**
 * 전세자금대출이율 서비스 구현 Class
 * @author 남윤혁
 * @since 2011-12-07
 */
public class LoanHouseDepositRateServiceImpl implements
		LoanHouseDepositRateService {

	private LoanHouseDepositRateDao loanHouseDepositRateDao;

	public void setLoanHouseDepositRateDao(LoanHouseDepositRateDao loanHouseDepositRateDao) {
		this.loanHouseDepositRateDao = loanHouseDepositRateDao;
	}
	
	public boolean isDuplicate(LoanHouseDepositRate loanHouseDepositRate) {
		// TODO Auto-generated method stub
		return false;
	}

	public long registerLoanHouseDepositRate(
			LoanHouseDepositRate loanHouseDepositRate) {
		// 정합성 체크
		checkInvalidate(loanHouseDepositRate);
		
		// DB 저장
		long id = this.loanHouseDepositRateDao.createLoanHouseDepositRate(loanHouseDepositRate);
		
		// id 반환
		return id;
	}

	/**
	 * 정합성 체크
	 * @param loanHouseDepositRate
	 */
	private void checkInvalidate(LoanHouseDepositRate loanHouseDepositRate) {
		if (loanHouseDepositRate == null) {
			throw new RuntimeException("전세자금대출이율 정보가 없습니다.");
		}
		
		if (loanHouseDepositRate.getStartUseDate() == null) {
			throw new RuntimeException("사용시작일자 정보가 없습니다.");
		}
		
		if (loanHouseDepositRate.getEndUseDate() == null) {
			throw new RuntimeException("사용종료일자 정보가 없습니다.");
		}
	}

}
