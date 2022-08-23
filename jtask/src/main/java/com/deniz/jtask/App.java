package com.deniz.jtask;



import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Create
    	 */
    	/*
    	create(new Customer("Deniz"));
    	create(new Customer("Ali"));
    	create(new Customer("Ayşe"));

    	create(new Account("Deposit", 1000.0, 1));
    	create(new Account("Checking", 1000.0, 1));
    	create(new Account("Deposit", 1000.0, 2));
    	create(new Account("Deposit", 1000.0, 3));
    	
    	create(new Address("Asd Mahallaesi Zxc Sokak No:12/2 Atasehir/Istanbul", "Atasehir", "Istanbul", "Marmara", "Turkey", 1));
    	create(new Address("Asd Mahallaesi Zxc Sokak No:15/5 Kadikoy/Istanbul", "Kadikoy", "Istanbul", "Marmara", "Turkey", 2));
    	create(new Address("Asd Mahallaesi Zxc Sokak No:12/6 Besiktas/Istanbul", "Besiktas", "Istanbul", "Marmara", "Turkey", 3));

    	
    	create(new Telephone("Mobile", "+905555555555", 1));
    	create(new Telephone("Work", "+905555555556", 2));
    	create(new Telephone("Home", "+905555555557", 3));
    	*/
    	
    	
    	/*
    	 * 	Read
    	 */
    	/*
    	//Read All
    	
    	System.out.println("*******************");
    	for(Object object: getAll(Account.class)) {
    		System.out.println(object.toString());
    	}
    	System.out.println("*******************");

    	
    	System.out.println("*******************");

    	for(Object object: getAll(Customer.class)) {
    		System.out.println(object.toString());
    	}
    	System.out.println("*******************");

    	
    	//Read by Id
    	
    	System.out.println(getById(1, Account.class).toString());
    	System.out.println(getById(3, Customer.class).toString());

    	/*
    	 * Update
    	 */
    	/*
    	Account account = (Account) getById(3, Account.class);
    	account.setAccountType("Checking");
    	account.setAccountBalance(1500);
    	
    	update(account);
    	
    	System.out.println(getById(3, Account.class).toString());

    	/*
    	 * Delete
    	 */
    	/*
    	delete(account);
    	
    	System.out.println("*******************");
    	for(Object object: getAll(Account.class)) {
    		System.out.println(object.toString());
    	}
    	System.out.println("*******************");
    	*/
	}
    
    public static void create(Object object) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
    }
    
    public static <T> List<T> getAll(Class<T> cls) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<T> criteria = builder.createQuery(cls);
    	Root<T> root = criteria.from(cls);
    	criteria.select(root);
    	Query<T> query = session.createQuery(criteria);
    	List<T> results = query.getResultList();
		session.close();

    	return results;
    }

    public static <T> Object getById(int id, Class<T> cls) {
    	Object obj = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        obj = (Object) session.get(cls, id);
        session.close();
        return obj;
	}
    
    public static void update(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
      }
    
    public static void delete(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
      }
}
