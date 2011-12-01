package com.kyoborealco.hrm.service;

import com.kyoborealco.hrm.entity.LoanHouseDepositRate;

/**
 * 전세자금대출이율 서비스 Interface
 * @author 남윤혁
 * @since 2011-11-30
 */
public interface LoanHouseDepositRateService {

	/**
	 * 전세자금대출이율 중복 체크
	 * @param loanHouseDepositRate 전세자금대출이율 중복확인용 정보
	 * @return true: 중복 / false: 중복건 없음
	 */
	boolean isDuplicate(LoanHouseDepositRate loanHouseDepositRate);

	/**
	 * 전세자금대출이율 등록
	 * @param loanHouseDepositRate 등록할 전세자금대출이율 정보
	 * @return 등록된 후 id값
	 */
	long registerLoanHouseDepositRate(LoanHouseDepositRate loanHouseDepositRate);

}
