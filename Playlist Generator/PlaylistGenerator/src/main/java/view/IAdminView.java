package view;

interface IAdminDataProvider {

    String getSongTitle();
    String getSongGenre();
    String getSongArtist();
    Integer getSongViews();
    Integer getSongId();
    
    Integer getUserId();
    String getUsername();
    String getPassword();
    
    boolean getPdfChecked();
    boolean getTxtChecked();
}

interface IAdminDataSongSetter {
	
	void setSongTitle(String title);
	void setSongGenre(String genre);
	void setSongArtist(String artist);
	void setSongViews(Integer views);
	void setSongId(Integer id);
	
}

interface IAdminDataUserSetter {
	
	void setUsername(String username);
	void setPassword(String password);
	void setUserId(Integer id);
}

interface IAdminProvider {
	 void showErrorMessage(String message);
	 void showSuccessMessage(String message);
	 void createJTable(Object rowData[][], Object columnNames[]);
}

public interface IAdminView extends IAdminDataProvider, IAdminProvider, IAdminDataSongSetter, IAdminDataUserSetter{
}
