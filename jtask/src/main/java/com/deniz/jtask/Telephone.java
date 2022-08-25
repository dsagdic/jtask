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
	
	public void create(Telephone object) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
    }
	
	public List<Telephone> getAll() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<Telephone> criteria = builder.createQuery(Telephone.class);
    	Root<Telephone> root = criteria.from(Telephone.class);
    	criteria.select(root);
    	Query<Telephone> query = session.createQuery(criteria);
    	List<Telephone> results = query.getResultList();
		session.close();

    	return results;
    }
	
    public Telephone getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();        
        Telephone obj = (Telephone) session.get(Telephone.class, id);
        session.close();
        return obj;
	}
    
    public static void update(Telephone object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void delete(Telephone object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
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
