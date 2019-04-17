package model.persistance;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.Playlist;
import model.Song;
import model.User;

public class PlaylistDAO {

	public static SessionFactory getSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure().addAnnotatedClass(User.class);
		configObj.configure().addAnnotatedClass(Playlist.class);
		configObj.configure().addAnnotatedClass(Song.class);
		
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return factoryObj;
	}
	
	// create
	public static Integer createPlaylistRecord(Playlist playlistObj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		Integer playlistID = null;

		try {
			tx = session.beginTransaction();
			playlistID = (Integer) session.save(playlistObj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return playlistID;
	}

	// update
	public static void updatePlaylistRecord(Integer id, Playlist playlistObj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Playlist playlist = (Playlist)session.get(Playlist.class, id);
			playlist.setTitle(playlistObj.getTitle());

			session.update(playlist);
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
	public static void deletePlaylistRecord(int playlistId) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Playlist playlist = (Playlist) session.get(Playlist.class, playlistId);
			session.delete(playlist);
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
	public static Playlist findRecordById(int playlistId) {
		Session sessionObj = getSessionFactory().openSession();
		Playlist p = (Playlist) sessionObj.get(Playlist.class, playlistId);
		sessionObj.close();
		return p;
	}
	
	public static void removeSongFromPlaylist(Integer playlistId, Integer songId ) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Playlist playlist = (Playlist)session.get(Playlist.class, playlistId);
            Song song = (Song)session.get(Song.class, songId);
            playlist.getSongs().remove(song);
            session.save(playlist);
            transaction.commit();
        } catch( Exception e ) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	
	@SuppressWarnings({ "finally", "unchecked" })
	public static List<Playlist> findAll(Integer id) {

		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		List<Playlist> playlists = null;

		try {
			tx = session.beginTransaction();
			playlists = session.createQuery("FROM Playlist WHERE user_id = " + id).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			return playlists;
		}
	}
	
}
