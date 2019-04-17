package view;

import java.util.List;
import javax.swing.JList;
import javax.swing.ListModel;

import model.Song;
import model.User;

interface IListViewProvider {

    JList getList();
    List<Song> getListOfSongs();
    void setJListSongs(String[] elements);
    User getPlaylistOwner();
    String getSearchedPlaylist();
}

public interface IListView extends IListViewProvider {
}
