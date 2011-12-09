package com.kyoborealco.hrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * �����ڱݴ������� entity
 * @author ������
 * @since 2011-12-01
 */
@NamedQueries({

	// Unique Key�� �̿��ؼ� ��ȸ
	@NamedQuery(
		name = "findByUK",
		query = "from LoanHouseDepositRate where startUseDate = :startUseDate and endUseDate = :endUseDate "
	),
})

@Entity
@Table(name = "TH_LHDRXM")
public class LoanHouseDepositRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LHDR_NUMB", columnDefinition="int")
	private long id;
	
	/**
	 * ����������
	 * ex) 2011��12��01�� => 20111201
	 */
	@Column(name = "SUSE_DATE", length = 8, nullable = false, columnDefinition = "char(8)")
	private String startUseDate;
	
	/**
	 * �����������
	 * ex) 2011��12��31�� => 20111231
	 */
	@Column(name = "EUSE_DATE", length = 8, nullable = false, columnDefinition = "char(8)")
	private String endUseDate;
	
	/**
	 * ȸ�缳������
	 */
	@Column(name = "LHDE_RATE", nullable = false, columnDefinition="numeric(5,3)")
	private double companyRate;

	/**
	 * ����û����
	 * irs -> Internal Revenue Service
	 */
	@Column(name = "TAXA_RATE", nullable = false, columnDefinition="numeric(5,3)")
	private double irsRate;
	
	/**
	 * �����ͻ��� �����ID
	 */
	@Column(name = "REEM_CODE", length = 20)
	private String createUserId;
	
	/**
	 * �����ͻ��� �ð�
	 */
	@Column(name = "REGI_DATE")
	private Date createDateTime;
	
	/**
	 * ������ �������� �����ID
	 */
	@Column(name = "UPEM_CODE", length = 20)
	private String updateUserId;
	
	/**
	 * ������ �������� �ð�
	 */
	@Column(name = "UPDA_DATE")
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
