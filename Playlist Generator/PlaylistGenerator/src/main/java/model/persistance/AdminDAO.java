package model.persistance;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.Administrator;

public class AdminDAO {

	// creating config and adding annotated class
    public static SessionFactory getSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure().addAnnotatedClass(Administrator.class);
        
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);      
        return factoryObj;
    }
 
    @SuppressWarnings("finally")
	public static Administrator findUserByEmail(String email) {
    	Session session = getSessionFactory().openSession();
		Transaction tx = null;
		List<Administrator> admins = null;

		try {
			tx = session.beginTransaction();
		    admins = session.createQuery("FROM Administrator WHERE email LIKE '%" + email + "%'").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			for (Iterator iterator1 = admins.iterator(); iterator1.hasNext();) {
				Administrator a = (Administrator) iterator1.next();
				return a;
			}
			return null;
		}
		
    }
    
}
