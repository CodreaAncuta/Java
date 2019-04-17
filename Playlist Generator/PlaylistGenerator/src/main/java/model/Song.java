package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="songId")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "genre")
	private String genre;
	
	@Column(name = "artist")
	private String artist;

	@Column(name = "views")
	private int views;
	
	@ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER)
	private List<Playlist> playlists = new ArrayList<Playlist>() ;
	
	public Song() {
		
	}
	
	public Song(String title, String genre, String artist, int views) {
		this.title = title;
		this.genre = genre;
		this.artist = artist;
		this.views = views;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", genre=" + genre + ", artist=" + artist + ", views=" + views
				+ "]";
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	
	
	
}
