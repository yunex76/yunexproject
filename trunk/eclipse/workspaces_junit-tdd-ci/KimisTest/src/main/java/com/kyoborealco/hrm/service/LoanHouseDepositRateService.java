package com.kyoborealco.hrm.service;

import com.kyoborealco.hrm.entity.LoanHouseDepositRate;

/**
 * �����ڱݴ������� ���� Interface
 * @author ������
 * @since 2011-11-30
 */
public interface LoanHouseDepositRateService {

	/**
	 * �����ڱݴ������� �ߺ� üũ
	 * @param loanHouseDepositRate �����ڱݴ������� �ߺ�Ȯ�ο� ����
	 * @return true: �ߺ� / false: �ߺ��� ����
	 */
	boolean isDuplicate(LoanHouseDepositRate loanHouseDepositRate);

	/**
	 * �����ڱݴ������� ���
	 * @param loanHouseDepositRate ����� �����ڱݴ������� ����
	 * @return ��ϵ� �� id��
	 */
	long registerLoanHouseDepositRate(LoanHouseDepositRate loanHouseDepositRate);

}
