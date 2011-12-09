package com.kyoborealco.hrm.dao.impl;

import java.util.Map;
import java.util.HashMap;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.kyoborealco.hrm.dao.LoanHouseDepositRateDao;
import com.kyoborealco.hrm.entity.LoanHouseDepositRate;

/**
 * �����ڱݴ������� DAO ���� Ŭ����
 * @author ������
 * @since 2011-12-08
 */
public class LoanHouseDepositRateDaoImpl implements LoanHouseDepositRateDao {

	private JpaTemplate jpaTemplate;
	
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}
	
	/**
	 * �����ڱݴ������� ����
	 */
	@Transactional
	public long createLoanHouseDepositRate(
			LoanHouseDepositRate loanHouseDepositRate) {
		jpaTemplate.merge(loanHouseDepositRate);
		
		// id ����
		loanHouseDepositRate.setId(findByUK(loanHouseDepositRate).getId());
		
		return loanHouseDepositRate.getId();
	}

	/**
	 * Unique Key�� �̿��ؼ� 
	 * @param loanHouseDepositRate
	 * @return
	 */
	@Transactional(readOnly = true)
	private LoanHouseDepositRate findByUK(LoanHouseDepositRate loanHouseDepositRate) {

		Map<String, String> params = new HashMap<String, String>();
        
		params.put("startUseDate", loanHouseDepositRate.getStartUseDate());
		params.put("endUseDate", loanHouseDepositRate.getEndUseDate());
		
		return (LoanHouseDepositRate) jpaTemplate.findByNamedQueryAndNamedParams("findByUK", params).get(0);
	}

}
