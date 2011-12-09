package com.kyoborealco.hrm.service.impl;

import com.kyoborealco.hrm.dao.LoanHouseDepositRateDao;
import com.kyoborealco.hrm.entity.LoanHouseDepositRate;
import com.kyoborealco.hrm.service.LoanHouseDepositRateService;

/**
 * �����ڱݴ������� ���� ���� Class
 * @author ������
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
		// ���ռ� üũ
		checkInvalidate(loanHouseDepositRate);
		
		// DB ����
		long id = this.loanHouseDepositRateDao.createLoanHouseDepositRate(loanHouseDepositRate);
		
		// id ��ȯ
		return id;
	}

	/**
	 * ���ռ� üũ
	 * @param loanHouseDepositRate
	 */
	private void checkInvalidate(LoanHouseDepositRate loanHouseDepositRate) {
		if (loanHouseDepositRate == null) {
			throw new RuntimeException("�����ڱݴ������� ������ �����ϴ�.");
		}
		
		if (loanHouseDepositRate.getStartUseDate() == null) {
			throw new RuntimeException("���������� ������ �����ϴ�.");
		}
		
		if (loanHouseDepositRate.getEndUseDate() == null) {
			throw new RuntimeException("����������� ������ �����ϴ�.");
		}
	}

}
