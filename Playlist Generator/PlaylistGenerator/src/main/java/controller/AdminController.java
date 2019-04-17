package controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import model.Song;
import model.User;
import model.persistance.SongDAO;
import model.persistance.UserDAO;
import model.report.Report;
import model.report.ReportFactory;
import view.IAdminView;

@SuppressWarnings("unused")
public class AdminController {
	private final IAdminView adminView;

	public AdminController(IAdminView adminView) {
		this.adminView = adminView;
	}

	public void createSong() {
		if (adminView.getSongViews() >= 0) {

			Song songObj = new Song(adminView.getSongTitle(), adminView.getSongGenre(), adminView.getSongArtist(),
					adminView.getSongViews());
			SongDAO.createSongRecord(songObj);
			adminView.showSuccessMessage("The song has been succesfully created!");

		} else
			adminView.showErrorMessage("The views number must be a positive number!");
	}

	public void updateSong() {
		if (adminView.getSongViews() >= 0) {
			Song songObj = new Song(adminView.getSongTitle(), adminView.getSongGenre(), adminView.getSongArtist(),
					adminView.getSongViews());
			SongDAO.updateSongRecord(adminView.getSongId(), songObj);
			adminView.showSuccessMessage("The song has been succesfully updated!");
		} else
			adminView.showErrorMessage("The views number must be a positive number!");
	}

	public void deleteSong() {
		SongDAO.deleteSongRecord(adminView.getSongId());
		adminView.showSuccessMessage("The song has been succesfully deleted!");
	}

	public void retrieveSong() {
		Song s = SongDAO.findSongById(adminView.getSongId());
		adminView.setSongId(s.getId());
		adminView.setSongTitle(s.getTitle());
		adminView.setSongArtist(s.getArtist());
		adminView.setSongGenre(s.getGenre());
		adminView.setSongViews(s.getViews());
	}

	public void createUser() {
		User userObj = new User(adminView.getUsername(), adminView.getPassword());

		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		if (adminView.getPassword().matches(pattern)) {
			UserDAO.createUserRecord(userObj);
			adminView.showSuccessMessage("The user has been succesfully created!");
		} else
			adminView.showErrorMessage("The password must have at least 8 chars, contain at least a digit," + "\n"
					+ " at least one lower alpha char and one upper alpha char, at least one char within a set of special chars, "
					+ "\n" + "and have no whitespaces");
	}

	public void retrieveUser() {
		User u = UserDAO.findUserRecordById(adminView.getUserId());
		adminView.setUserId(u.getId());
		adminView.setUsername(u.getUsername());
		adminView.setPassword(u.getPassword());
	}

	public void updateUser() {
		User userObj = new User(adminView.getUsername(), adminView.getPassword());
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		if (adminView.getPassword().matches(pattern)) {
			UserDAO.updateUserRecord(adminView.getUserId(), userObj);
			adminView.showSuccessMessage("The user has been succesfully updated!");
		} else
			adminView.showErrorMessage("The password must have at least 8 chars, contain at least a digit," + "\n"
					+ " at least one lower alpha char and one upper alpha char, at least one char within a set of special chars, "
					+ "\n" + "and have no whitespaces");

	}

	public void deleteUser() {
		UserDAO.deleteUserRecord(adminView.getUserId());
		adminView.showSuccessMessage("The user has been succesfully deleted!");
	}

	public String getAbsolutePathFileChooser() {
		File dest = null;
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Choose a directory to save your file: ");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (jfc.getSelectedFile().isDirectory()) {
				System.out.println("You selected the directory: " + jfc.getSelectedFile());
				dest = jfc.getSelectedFile();
			}
		}

		return dest.getAbsolutePath();
	}

	public void generateUserReport() {

		ReportFactory reportFactory = new ReportFactory();

		if (adminView.getPdfChecked()) {
			User user = UserDAO.findUserRecordById(adminView.getUserId());
			String absPath = getAbsolutePathFileChooser();
			Report pdf = reportFactory.createReport("pdf", user, absPath);
		} else if (adminView.getTxtChecked()) {
			User user = UserDAO.findUserRecordById(adminView.getUserId());
			String absPath = getAbsolutePathFileChooser();
			Report txt = reportFactory.createReport("txt", user, absPath);
		} else {
			JOptionPane.showInternalMessageDialog(null, "The type of the pdf must be specified!");
		}
	}

}
