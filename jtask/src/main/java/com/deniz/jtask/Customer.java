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
	
	public void create(Customer object) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
    }
	
	public List<Customer> getAll() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
    	Root<Customer> root = criteria.from(Customer.class);
    	criteria.select(root);
    	Query<Customer> query = session.createQuery(criteria);
    	List<Customer> results = query.getResultList();
		session.close();

    	return results;
    }
	
    public Customer getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();        
        Customer obj = (Customer) session.get(Customer.class, id);
        session.close();
        return obj;
	}
    
    public static void update(Customer object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void delete(Customer object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }
    
	public Customer() {
		   
	}

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}
	
	

}
