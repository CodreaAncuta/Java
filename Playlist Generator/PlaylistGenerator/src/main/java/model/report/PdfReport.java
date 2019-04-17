package model.report;

import java.io.FileNotFoundException;
import java.util.Iterator;


import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.util.List;

import model.Playlist;
import model.Song;
import model.User;
import model.persistance.PlaylistDAO;

@SuppressWarnings("rawtypes")
public class PdfReport implements Report {

	public PdfReport() {

	}

	@Override
	public boolean generateReport(User u, String dest) {

		try {
			
		    
		    String finalDest = dest.replace('\\','/');
		    finalDest += "/PlaylistsReport.pdf";
		    System.out.println(finalDest);
		    
		    PdfWriter writer = new PdfWriter(finalDest);
		    
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);

			document.setBackgroundColor(Color.RED);

			Paragraph paragraph = new Paragraph("PLAYLISTS REPORT FOR USER: " + u.getUsername());
			paragraph.setFontColor(Color.RED);
			document.add(paragraph);

			float[] pointColumnWidths = { 150F };
			Table table = new Table(pointColumnWidths);

			List<Playlist> playlists = PlaylistDAO.findAll(u.getId());
			for (Iterator iterator1 = playlists.iterator(); iterator1.hasNext();) {
				Playlist p = (Playlist) iterator1.next();
				document.add(new Paragraph("Playlist title: " + p.getTitle()));

				List<Song> songs = p.getSongs();

				for (Iterator iterator2 = songs.iterator(); iterator2.hasNext();) {
					Song s = (Song) iterator2.next();
					table.addCell(new Cell().add(s.getTitle()));

				}

				document.add(table);
				table = new Table(pointColumnWidths);

			}

			document.close();

			return true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return false;

	}

}
