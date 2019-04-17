package model.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import model.Playlist;
import model.Song;
import model.User;
import model.persistance.PlaylistDAO;

@SuppressWarnings("rawtypes")
public class TxtReport implements Report {

	public TxtReport() {

	}

	@Override
	public boolean generateReport(User u, String dest) {
		
		String finalDest = dest.replace('\\', '/');
		finalDest += "/PlaylistsReport.txt";
		System.out.println(finalDest);

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(finalDest, true));
			writer.append("PLAYLIST REPORT FOR USER: " + u.getUsername());
			writer.newLine();
			writer.newLine();
			
			List<Playlist> playlists = PlaylistDAO.findAll(u.getId());
			for (Iterator iterator1 = playlists.iterator(); iterator1.hasNext();) {
				Playlist p = (Playlist) iterator1.next();
				writer.append("Playlist Title: " + p.getTitle());
				writer.newLine();

				List<Song> songs = p.getSongs();

				for (Iterator iterator2 = songs.iterator(); iterator2.hasNext();) {
					Song s = (Song) iterator2.next();
					writer.append("Song: " + s.getTitle());
					writer.newLine();
				}

				
				writer.close();

				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
