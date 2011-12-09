package com.kyoborealco.hrm.dao.impl;

import java.util.Map;
import java.util.HashMap;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.kyoborealco.hrm.dao.LoanHouseDepositRateDao;
import com.kyoborealco.hrm.entity.LoanHouseDepositRate;

/**
 * 전세자금대출이율 DAO 구현 클래스
 * @author 남윤혁
 * @since 2011-12-08
 */
public class LoanHouseDepositRateDaoImpl implements LoanHouseDepositRateDao {

	private JpaTemplate jpaTemplate;
	
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}
	
	/**
	 * 전세자금대출이율 저장
	 */
	@Transactional
	public long createLoanHouseDepositRate(
			LoanHouseDepositRate loanHouseDepositRate) {
		jpaTemplate.merge(loanHouseDepositRate);
		
		// id 갱신
		loanHouseDepositRate.setId(findByUK(loanHouseDepositRate).getId());
		
		return loanHouseDepositRate.getId();
	}

	/**
	 * Unique Key를 이용해서 
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
