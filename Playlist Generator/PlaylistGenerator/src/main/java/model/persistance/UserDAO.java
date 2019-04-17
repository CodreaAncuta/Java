package model.persistance;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.Playlist;
import model.Song;
import model.User;

public class UserDAO {
	 
	// creating config and adding annotated class
    public static SessionFactory getSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure().addAnnotatedClass(User.class);
        configObj.configure().addAnnotatedClass(Playlist.class);
        configObj.configure().addAnnotatedClass(Song.class);
        
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);      
        return factoryObj;
    }
 
    // create
    public static Integer createUserRecord(User userObj) {
    	Session session = getSessionFactory().openSession();
		Transaction tx = null;
		Integer userID = null;

		try {
			tx = session.beginTransaction();
			userID = (Integer) session.save(userObj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userID;
    }
 
    // update
    public static void updateUserRecord(Integer id, User userObj) {
    	Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = (User)session.get(User.class, id);
			user.setUsername(userObj.getUsername());
			user.setPassword(userObj.getPassword());

			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
    }
 
    // delete
    public static void deleteUserRecord(Integer userId) {
    	Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			session.delete(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
 
    }
 
    // retrieve
    public static User findUserRecordById(Integer userId) {
        Session sessionObj = getSessionFactory().openSession();
        User user = (User) sessionObj.get(User.class, userId);
        sessionObj.close();
        return user;
    }
    
    @SuppressWarnings({ "finally", "unchecked" })
	public static User findUserRecordByUsername(String username) {
    	Session session = getSessionFactory().openSession();
		Transaction tx = null;
		List<User> users = null;

		try {
			tx = session.beginTransaction();
		    users = session.createQuery("FROM User WHERE username LIKE '%" + username + "%'").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			
			for (@SuppressWarnings("rawtypes")
			Iterator iterator1 = users.iterator(); iterator1.hasNext();) {
				User u = (User) iterator1.next();
				return u;
			}
			return null;
		}
		
    }
 
}
