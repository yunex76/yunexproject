package com.kyoborealco.hrm.entity;

import java.util.Date;

/**
 * 전세자금대출이율 entity
 * @author 남윤혁
 * @since 2011-12-01
 */
public class LoanHouseDepositRate {

	private long id;
	
	/**
	 * 사용시작일자
	 * ex) 2011년12월01일 => 20111201
	 */
	private String startUseDate;
	
	/**
	 * 사용종료일자
	 * ex) 2011년12월31일 => 20111231
	 */
	private String endUseDate;
	
	/**
	 * 회사설정이율
	 */
	private double companyRate;

	/**
	 * 국세청이율
	 * irs -> Internal Revenue Service
	 */
	private double irsRate;
	
	/**
	 * 데이터생성 사용자ID
	 */
	private String createUserId;
	
	/**
	 * 데이터생성 시간
	 */
	private Date createDateTime;
	
	/**
	 * 데이터 최종수정 사용자ID
	 */
	private String updateUserId;
	
	/**
	 * 데이터 최종수정 시간
	 */
	private Date updateDateTime;

	public LoanHouseDepositRate() {
	}

	public LoanHouseDepositRate(long id, String startUseDate,
			String endUseDate, double companyRate, double irsRate,
			String createUserId, Date createDateTime, String updateUserId,
			Date updateDateTime) {
		this.id = id;
		this.startUseDate = startUseDate;
		this.endUseDate = endUseDate;
		this.companyRate = companyRate;
		this.irsRate = irsRate;
		this.createUserId = createUserId;
		this.createDateTime = createDateTime;
		this.updateUserId = updateUserId;
		this.updateDateTime = updateDateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartUseDate() {
		return startUseDate;
	}

	public void setStartUseDate(String startUseDate) {
		this.startUseDate = startUseDate;
	}

	public String getEndUseDate() {
		return endUseDate;
	}

	public void setEndUseDate(String endUseDate) {
		this.endUseDate = endUseDate;
	}

	public double getCompanyRate() {
		return companyRate;
	}

	public void setCompanyRate(double companyRate) {
		this.companyRate = companyRate;
	}

	public double getIrsRate() {
		return irsRate;
	}

	public void setIrsRate(double irsRate) {
		this.irsRate = irsRate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
}
