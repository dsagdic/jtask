package com.deniz.jtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Telephone")
public class Telephone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telephone_id", unique = true, nullable = false)
	private int telephoneId;
	
	@Column(name = "telephone_no", nullable = false)
	private String telephoneNo;
	
	@Column(name = "telephone_type", nullable = false)
	private String telephoneType;
	
	@Column(name = "customer_id", nullable = false)
	private int customerId;

	public int getTelephoneId() {
		return telephoneId;
	}

	public void setTelephoneId(int telephoneId) {
		this.telephoneId = telephoneId;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getTelephoneType() {
		return telephoneType;
	}

	public void setTelephoneType(String telephoneType) {
		this.telephoneType = telephoneType;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String toString() {
		return "Telephone Id: " + this.telephoneId + " Telephone Type: " + this.telephoneType + " Telephone No: " + this.telephoneNo + " Customer Id: " + this.customerId;
	}
	
	public Telephone() {
		   
	}

	public Telephone(String telephoneType, String telephoneNo, int customerId) {
		super();
		this.telephoneType = telephoneType;
		this.telephoneNo = telephoneNo;
		this.customerId = customerId;
	}
}
