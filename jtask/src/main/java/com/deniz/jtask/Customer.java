package com.deniz.jtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", unique = true, nullable = false)
	private int customerId;
	
	@Column(name = "customer_name", nullable = false)
	private String customerName;
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String toString() {
		return "Customer Name: " + this.customerName + " Customer Id: " + this.customerId;
	}
	
	public Customer() {
		   
	}

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}
	
	

}
