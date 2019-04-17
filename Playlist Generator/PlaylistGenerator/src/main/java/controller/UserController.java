package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import model.Playlist;
import model.Song;
import model.User;
import model.persistance.PlaylistDAO;
import model.persistance.SongDAO;
import model.persistance.UserDAO;
import view.IUserView;

public class UserController {
	private final IUserView userView;
	private Song selectedSong;
	private ArrayList<Song> listOfSongs;
	
    public UserController(IUserView userView) {
        this.userView = userView;
        listOfSongs = new ArrayList<Song>();
    }

    @SuppressWarnings("rawtypes")
	public void setJTableSongs(List songs) {
    	
		String rowData[][] = new String[songs.size()][5];
    	String colsData[] = new String [] {"Id", "Title", "Genre", "Artist", "Views" };
		
		int i=0;
		for (Iterator iterator1 = songs.iterator(); iterator1.hasNext();) {
			Song s = (Song) iterator1.next();
			rowData[i][0] = String.valueOf(s.getId());
			rowData[i][1] = s.getTitle();
			rowData[i][2] = s.getGenre();
			rowData[i][3] = s.getArtist();
			rowData[i][4] = String.valueOf(s.getViews());
			i++;
		}
		
		userView.setJTableSongs(rowData,colsData);
    }
    
	public void searchSongsByFeature() {
		if (userView.getSearchOption().equals(userView.getSearchByArtist())) {
			List<Song> songs = SongDAO.findSongsByArtist(userView.getSearchField());
			this.setJTableSongs(songs);
		}
		else if (userView.getSearchOption().equals(userView.getSearchByGenre())) {
			List<Song> songs  = SongDAO.findSongsByGenre(userView.getSearchField());
			this.setJTableSongs(songs);
		} 
		else if (userView.getSearchOption().equals(userView.getSearchByViews())){
			List<Song> songs = SongDAO.findSongsByViews(Integer.parseInt(userView.getSearchField()));
			this.setJTableSongs(songs);
		}
	}

	public void playSong() {
		int idSong = selectedSong.getId();
	    Song song = SongDAO.findSongById(idSong);
		song.setViews(song.getViews() + 1);
		SongDAO.updateSongRecord(idSong, song);
	}

	public void jTableSelect() {
		
        int[] selectedRow = userView.getJTableSongs().getSelectedRows();
        int[] selectedColumns = userView.getJTableSongs().getSelectedColumns();

        for (int i = 0; i < selectedRow.length; i++) {
          for (int j = 0; j < selectedColumns.length; j++) {
            this.selectedSong = new Song();
            selectedSong.setId(Integer.parseInt(userView.getJTableSongs().getValueAt(selectedRow[i], 0).toString()));
            selectedSong.setTitle(userView.getJTableSongs().getModel().getValueAt(selectedRow[i], 1).toString());
            selectedSong.setGenre(userView.getJTableSongs().getModel().getValueAt(selectedRow[i], 2).toString());
            selectedSong.setArtist(userView.getJTableSongs().getModel().getValueAt(selectedRow[i], 3).toString());
            selectedSong.setViews(Integer.parseInt(userView.getJTableSongs().getModel().getValueAt(selectedRow[i], 4).toString()));
          }
        }
        
     }

	public void addSong() {
		System.out.println(selectedSong.getTitle());
		listOfSongs.add(selectedSong);
	}

	public void createPlaylist() {
		String playlistName = userView.getNewPlaylistName();
		User u = UserDAO.findUserRecordByUsername(userView.getUsername());
		System.out.println(u.getUsername());
		
		Playlist newPlaylist = new Playlist(playlistName);
		u.addPlaylist(newPlaylist);
		
		for( Song s: listOfSongs) {
			newPlaylist.getSongs().add(s);
		}
		PlaylistDAO.createPlaylistRecord(newPlaylist);
		
		for( Song s: newPlaylist.getSongs()) {
			System.out.println("Playlist " + playlistName + ": " + s.getTitle());
		}
		
	}

	public void displayExistingPlaylist() {
		listOfSongs.clear();
		String playlistSearched = userView.getEnterPlaylistTitle();
		Playlist searchedPlaylist = null;
		User u = UserDAO.findUserRecordByUsername(userView.getUsername());
		List<Playlist> playlists = u.getPlaylists();
		boolean ok = false;
		
		for (Iterator iterator1 = playlists.iterator(); iterator1.hasNext();) {
			Playlist p = (Playlist) iterator1.next();
			if(playlistSearched.equals(p.getTitle())) {
				ok = true;
				searchedPlaylist = p;
				break;
			}
		}
		
		if(ok) {
			List<Song> listOfSongs = searchedPlaylist.getSongs();
			userView.showPlaylistSongList(listOfSongs, u, playlistSearched);
		}
	}

	public void showPlaylists() {
		User u = UserDAO.findUserRecordByUsername(userView.getUsername());
		List<Playlist> playlists = u.getPlaylists();
		String showPlaylists = "";
		for (Iterator iterator1 = playlists.iterator(); iterator1.hasNext();) {
			Playlist p = (Playlist) iterator1.next();
			showPlaylists = showPlaylists + p.getTitle() + "\n"; 
		}
		
		JOptionPane.showMessageDialog(null, showPlaylists, "MY PLAYLISTS", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
