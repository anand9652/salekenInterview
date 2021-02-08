package com.salesken.anand.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

//mark class as an Entity 
@Entity
// defining class name as Table name
@Table
public class Transaction  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Defining transaction id as primary key
	@Id
	@Column
	private String transId;
	
	@Version
	private Integer version;
	
	@Column
	private String debitedFrom;
	@Column
	private String creditedTo;
	@Column
	private float amount;

	@Column
	private String transDate;

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getDebitedFrom() {
		return debitedFrom;
	}

	public void setDebitedFrom(String debitedFrom) {
		this.debitedFrom = debitedFrom;
	}

	public String getCreditedTo() {
		return creditedTo;
	}

	public void setCreditedTo(String creditedTo) {
		this.creditedTo = creditedTo;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

}