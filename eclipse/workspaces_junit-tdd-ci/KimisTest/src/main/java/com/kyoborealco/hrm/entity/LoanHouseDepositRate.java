package com.kyoborealco.hrm.entity;

import java.util.Date;

/**
 * �����ڱݴ������� entity
 * @author ������
 * @since 2011-12-01
 */
public class LoanHouseDepositRate {

	private long id;
	
	/**
	 * ����������
	 * ex) 2011��12��01�� => 20111201
	 */
	private String startUseDate;
	
	/**
	 * �����������
	 * ex) 2011��12��31�� => 20111231
	 */
	private String endUseDate;
	
	/**
	 * ȸ�缳������
	 */
	private double companyRate;

	/**
	 * ����û����
	 * irs -> Internal Revenue Service
	 */
	private double irsRate;
	
	/**
	 * �����ͻ��� �����ID
	 */
	private String createUserId;
	
	/**
	 * �����ͻ��� �ð�
	 */
	private Date createDateTime;
	
	/**
	 * ������ �������� �����ID
	 */
	private String updateUserId;
	
	/**
	 * ������ �������� �ð�
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
