package com.deniz.jtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false)
	private int addressId;
	
	@Column(name = "full_address", nullable = false)
	private String fullAddress;
	
	@Column(name = "county")
	private String county;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "country")
	private String country;

	@Column(name = "customer_id", nullable = false)
	private int customerId;
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String toString() {
		return "Address Id: " + this.addressId + " Full Address: " + this.fullAddress + " County: " + this.county + " Province: " + this.province + " Region: " + this.region + " Country: " + this.country + " Customer Id: " + this.customerId;
	}
	
	public Address() {
		   
	}

	public Address(String fullAddress, String county, String province, String region, String country, int customerId) {
		super();
		this.fullAddress = fullAddress;
		this.county = county;
		this.province = province;
		this.region = region;
		this.country = country;
		this.customerId = customerId;
	}
}
