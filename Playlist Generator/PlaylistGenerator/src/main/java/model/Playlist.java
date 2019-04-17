package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlists")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "playlistId")
	private int id;

	@Column(name = "title")
	private String title;

	 @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	 @JoinTable(
	        name = "playlists_songs", 
	        joinColumns = { @JoinColumn(name = "playlist_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "song_id") }
	    )
	private List<Song> songs = new ArrayList<Song>();

	@ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
	private User user;
	
	public Playlist() {

	}

	public Playlist(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	

}
