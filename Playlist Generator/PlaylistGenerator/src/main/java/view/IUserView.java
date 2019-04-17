package view;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.JTable;

import model.Song;
import model.User;

interface IUserDataProvider {

	String getSearchField();
	String getNewPlaylistName();
	String getPlaylistTitle();
	ButtonModel getSearchOption();
	ButtonModel getSearchByArtist();
	ButtonModel getSearchByGenre();
	ButtonModel getSearchByViews();
	JTable getJTableSongs();
	void setJTableSongs(String rowData[][], String colsData[]);
	String getUsername();
	String getEnterPlaylistTitle();
	
}

interface IUserProvider {
	
	void showPlaylistSongList(List<Song> listOfSongs, User u,String searchedPlaylist);
	
}

public interface IUserView extends IUserDataProvider, IUserProvider {
}
