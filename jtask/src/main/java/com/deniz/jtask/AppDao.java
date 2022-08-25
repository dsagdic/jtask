package com.deniz.jtask;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class AppDao {
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
