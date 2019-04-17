package view;

import java.awt.Dimension;

import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controller.AdminController;
import controller.UserController;


/**
 *
 * @author Ancuta
 */
public class RegularView extends javax.swing.JFrame implements IUserView{

	String username;
    /**
     * Creates new form RegularView
     */
    public RegularView(String user) {
    	setNimbus();
        initComponents();
        jTableSongs.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        username = user;
    
        UserController userController = new UserController(this);
		searchButton.addActionListener(e -> userController.searchSongsByFeature());
		playSongButton.addActionListener(e -> userController.playSong());
		jTableSongs.getSelectionModel().addListSelectionListener(e -> userController.jTableSelect());
		addSongButton.addActionListener(e -> userController.addSong());
		createPlaylistButton.addActionListener(e -> userController.createPlaylist());
		displayPlaylistButton.addActionListener(e -> userController.displayExistingPlaylist());
    }

    private void setNimbus() {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegularView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegularView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegularView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegularView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
	}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
    	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);

        searchByRadioBtnGroup = new javax.swing.ButtonGroup();
        playSongButton = new javax.swing.JButton();
        createPlaylistButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSongs = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        showPlaylistsButton = new javax.swing.JButton();
        displayPlaylistButton = new javax.swing.JButton();
        enterPlaylistTitleField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        byArtistRadio = new javax.swing.JRadioButton();
        byGenreRadio = new javax.swing.JRadioButton();
        byViewsRadio = new javax.swing.JRadioButton();
        addSongButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        newPlaylistName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regular User Page");

        playSongButton.setText("Play Song");

        createPlaylistButton.setText("CREATE PLAYLIST");

        jLabel1.setText("SEARCH:");

        jTableSongs.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableSongs);
        
        searchButton.setText("SEARCH");

        showPlaylistsButton.setText("SHOW PLAYLISTS");

        displayPlaylistButton.setText("DISPLAY PLAYLIST");

        jLabel2.setText("       ENTER PLAYLIST TITLE");

        searchByRadioBtnGroup.add(byArtistRadio);
        byArtistRadio.setText("BY ARTIST");

        searchByRadioBtnGroup.add(byGenreRadio);
        byGenreRadio.setText("BY GENRE");

        searchByRadioBtnGroup.add(byViewsRadio);
        byViewsRadio.setText("BY VIEWS");

        addSongButton.setText("ADD SONG");

        jLabel3.setText("PLAYLIST NAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(byGenreRadio)
                                    .addComponent(byArtistRadio)
                                    .addComponent(byViewsRadio))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(newPlaylistName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createPlaylistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showPlaylistsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(displayPlaylistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enterPlaylistTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(byArtistRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(byGenreRadio)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(byViewsRadio)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newPlaylistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createPlaylistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPlaylistsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterPlaylistTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayPlaylistButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>                        

   

    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton byArtistRadio;
    private javax.swing.JRadioButton byGenreRadio;
    private javax.swing.JRadioButton byViewsRadio;
    private javax.swing.JButton createPlaylistButton;
    private javax.swing.JButton displayPlaylistButton;
    private javax.swing.JTextField enterPlaylistTitleField;
    private javax.swing.JButton addSongButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSongs;
    private javax.swing.JTextField newPlaylistName;
    private javax.swing.JButton playSongButton;
    private javax.swing.JButton searchButton;
    private javax.swing.ButtonGroup searchByRadioBtnGroup;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton showPlaylistsButton;
    // End of variables declaration                   
    
	@Override
	public String getSearchField() {
		return searchField.getText();
	}

	@Override
	public String getNewPlaylistName() {
		return newPlaylistName.getText();
	}

	@Override
	public String getPlaylistTitle() {
		return enterPlaylistTitleField.getText();
	}

	@Override
	public ButtonModel getSearchOption() {
		return searchByRadioBtnGroup.getSelection();
	}

	@Override
	public ButtonModel getSearchByArtist() {
		return byArtistRadio.getModel();
	}

	@Override
	public ButtonModel getSearchByGenre() {
		return byGenreRadio.getModel();
	}

	@Override
	public ButtonModel getSearchByViews() {
		return byViewsRadio.getModel();
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
		return username;
	}
	
	
}
