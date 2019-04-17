package PlaylistGenerator2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.JTable;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.UserController;
import model.Playlist;
import model.Song;
import model.User;
import model.persistance.UserDAO;
import view.ILoginView;
import view.IUserView;


class UserControllerTests {

	@Test
	public void givenPlaylistTitle_DisplayPlaylisy() {

		// mock creation of interface
		IUserView userView = mock(IUserView.class);
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(new Song("song", "genre", "arti", 10));
		
		String colsData[] = new String [] {"Id", "Title", "Genre", "Artist", "Views" };
		String rowData[][] = new String[songs.size()][5];
		
		int i = 0;
		for (Iterator iterator1 = songs.iterator(); iterator1.hasNext();) {
			Song s = (Song) iterator1.next();
			rowData[i][0] = String.valueOf(s.getId());
			rowData[i][1] = s.getTitle();
			rowData[i][2] = s.getGenre();
			rowData[i][3] = s.getArtist();
			rowData[i][4] = String.valueOf(s.getViews());
			i++;
		}
		
		TestUserView uView = new TestUserView(rowData, colsData, null);
		UserController controller = new UserController(uView);
	   
		controller.setJTableSongs(songs);
		
		//assertEquals(userView.getJTableSongs(), uView.getJTableSongs());
		assertEquals(userView.getNewPlaylistName(), uView.getNewPlaylistName());
	}

	

	class TestUserView implements IUserView {
		private String[][] data;
		private String[] cols;
		private JTable jTableSongs;
		private String playlistName;

		TestUserView(String[][] d, String[] c, String playlistName) {
			this.data = d;
			this.cols = c;
			this.jTableSongs = new JTable();
			this.playlistName = playlistName;
		}


		@Override
		public String getSearchField() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getNewPlaylistName() {
			return playlistName;
		}

		@Override
		public String getPlaylistTitle() {
			return null;
		}

		@Override
		public ButtonModel getSearchOption() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ButtonModel getSearchByArtist() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ButtonModel getSearchByGenre() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ButtonModel getSearchByViews() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public JTable getJTableSongs() {
			return jTableSongs;
		}

		@Override
		public void setJTableSongs(String[][] rowData, String[] colsData) {
			jTableSongs.setModel(new javax.swing.table.DefaultTableModel(rowData,colsData));
			
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEnterPlaylistTitle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void showPlaylistSongList(List<Song> listOfSongs, User u, String searchedPlaylist) {
			// TODO Auto-generated method stub
			
		}

		
	}
}
