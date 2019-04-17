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

@SuppressWarnings({"rawtypes", "unchecked"})
public class SongDAO {

	public static SessionFactory getSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure().addAnnotatedClass(Song.class);
		configObj.configure().addAnnotatedClass(Playlist.class);
		configObj.configure().addAnnotatedClass(User.class);
		
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return factoryObj;
	}

	// create
	public static Integer createSongRecord(Song songObj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		Integer songID = null;

		try {
			tx = session.beginTransaction();
			songID = (Integer) session.save(songObj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return songID;
	}

	// display all records as a list
	public static List displayRecords() {
		Session sessionObj = getSessionFactory().openSession();
		List allSongsList = sessionObj.createQuery("FROM Song").list();

		sessionObj.close();
		return allSongsList;
	}

	// update
	public static void updateSongRecord(Integer id, Song songObj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Song song = (Song)session.get(Song.class, id);
			song.setTitle(songObj.getTitle());
			song.setArtist(songObj.getArtist());
			song.setGenre(songObj.getGenre());
			song.setViews(songObj.getViews());

			session.update(song);
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
	public static void deleteSongRecord(Integer songId) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Song song = (Song) session.get(Song.class, songId);
			session.delete(song);
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
	public static Song findSongById(Integer songId) {
		Session sessionObj = getSessionFactory().openSession();
		Song song = (Song) sessionObj.get(Song.class, songId);
		sessionObj.close();
		return song;
	}

	@SuppressWarnings("finally")
	public static List<Song> findSongsByGenre(String genre) {
		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		List<Song> songs = null;

		try {
			tx = session.beginTransaction();
		    songs = session.createQuery("FROM Song WHERE genre LIKE '%" + genre + "'").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			return songs;
		}
	}

	@SuppressWarnings("finally")
	public static List<Song> findSongsByArtist(String artist) {
		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		List<Song> songs = null;

		try {
			tx = session.beginTransaction();
		    songs = session.createQuery("FROM Song WHERE artist LIKE '%" + artist + "%'").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			return songs;
		}
	}

	@SuppressWarnings("finally")
	public static List<Song> findSongsByViews(Integer views) {

		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		List<Song> songs = null;

		try {
			tx = session.beginTransaction();
		    songs = session.createQuery("FROM Song WHERE views = " + views).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			return songs;
		}
	}

}
