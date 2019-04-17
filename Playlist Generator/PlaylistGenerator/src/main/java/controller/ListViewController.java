package controller;

import java.util.Iterator;
import java.util.List;

import model.Playlist;
import model.Song;
import model.User;
import model.persistance.PlaylistDAO;
import model.persistance.SongDAO;
import view.IListView;
import view.ListView;

@SuppressWarnings({"rawtypes"})
public class ListViewController {
	private final IListView listView;
	private String selectedSongItem;
	//private int selectedIndex;
	
	public ListViewController(ListView listView) {
		this.listView = listView;
		setSongList();
	}

	public void removeSong() {
		User user = listView.getPlaylistOwner();
		List<Playlist> playlists = user.getPlaylists();
		Playlist searchedPlaylist = null;
		boolean ok = false;

		for (Iterator iterator1 = playlists.iterator(); iterator1.hasNext();) {
			Playlist p = (Playlist) iterator1.next();
			if (listView.getSearchedPlaylist().equals(p.getTitle())) {
				ok = true;
				searchedPlaylist = p;
				break;
			}
		}

		if (ok) {
			List<Song> songs = searchedPlaylist.getSongs();
			for (Iterator iterator1 = songs.iterator(); iterator1.hasNext();) {
				Song s = (Song) iterator1.next();
				if (selectedSongItem.equals(s.getTitle())) {
					
					PlaylistDAO.removeSongFromPlaylist(searchedPlaylist.getId(), s.getId());
					
					listView.getListOfSongs().remove(s);
					break;
				}
			}
		}
		
		for( Song s : searchedPlaylist.getSongs())
			System.out.println(s.getTitle());
		
		  setSongList();

	}

	public void setSongList() {
		String[] elements = new String[listView.getListOfSongs().size()];
		int i = 0;

		for (Iterator iterator1 = listView.getListOfSongs().iterator(); iterator1.hasNext();) {
			Song p = (Song) iterator1.next();
			elements[i] = p.getTitle();
			i++;
		}

		listView.setJListSongs(elements);
	}

	public void songListSelectionListener() {
		String selectedItem = (String) listView.getList().getSelectedValue();
		this.selectedSongItem = selectedItem;
		/*int index = listView.getList().getSelectedIndex();
		this.selectedIndex = index;
		System.out.println(index);*/
	}
}
