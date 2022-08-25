package com.deniz.jtask;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
	
	public void create(Address object) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
    }
	
	public List<Address> getAll() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<Address> criteria = builder.createQuery(Address.class);
    	Root<Address> root = criteria.from(Address.class);
    	criteria.select(root);
    	Query<Address> query = session.createQuery(criteria);
    	List<Address> results = query.getResultList();
		session.close();

    	return results;
    }
	
    public Address getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();        
        Address obj = (Address) session.get(Address.class, id);
        session.close();
        return obj;
	}
    
    public static void update(Address object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void delete(Address object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
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
