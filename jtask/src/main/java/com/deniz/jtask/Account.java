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
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private int accountId;
	
	@Column(name = "account_type", nullable = false)
	private String accountType;
	
	@Column(name = "account_balance", nullable = false)
	private double accountBalance;
	
	@Column(name = "customer_id", nullable = false)
	private int customerId;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String toString() {
		return "Account Id: " + this.accountId + " Account Type: " + this.accountType + " Account Balance: " + this.accountBalance + " Customer Id: " + this.customerId;
	}
	
	public void create(Account object) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
    }
	
	public List<Account> getAll() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
    	Root<Account> root = criteria.from(Account.class);
    	criteria.select(root);
    	Query<Account> query = session.createQuery(criteria);
    	List<Account> results = query.getResultList();
		session.close();

    	return results;
    }
	
    public Account getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();        
        Account obj = (Account) session.get(Account.class, id);
        session.close();
        return obj;
	}
    
    public static void update(Account object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void delete(Account object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }
	
	public Account() {
		   
	}

	public Account(String accountType, double accountBalance, int customerId) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customerId = customerId;
	}


}
