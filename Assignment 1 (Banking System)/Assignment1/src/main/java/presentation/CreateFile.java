package presentation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

	BufferedWriter writer;
	public void	appendToFileAndClose(String s) {
		try {
			writer = new BufferedWriter(new FileWriter("EmployeeActivity.txt", true));
			writer.newLine();
			writer.append(s);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
