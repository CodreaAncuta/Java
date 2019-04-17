package bll.validators;

import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Client;

public class AgeValidator implements Validator<Client> {

	public void validate(Client c) {
		
		String yearDigits;
		String finalBirthYear = "0";
		
		if (c.getSsn().substring(0, 1).equals("1") || c.getSsn().substring(0, 1).equals("2")) {
			 yearDigits = c.getSsn().substring(1, 3);
			 finalBirthYear = "19"+yearDigits;
		}
		else if (c.getSsn().substring(0, 1).equals("5") || c.getSsn().substring(0, 1).equals("6")) {
			 yearDigits = c.getSsn().substring(1, 3);
			 finalBirthYear = "20"+yearDigits;
		}
		
		Calendar cal = Calendar.getInstance();
		int currYear = cal.get(Calendar.YEAR);
		
		if (currYear - Integer.parseInt(finalBirthYear)  < 18) {
			JOptionPane.showMessageDialog(null, "The client must be over 18!");
			throw new IllegalArgumentException("The client age is not respected!");
		}

	}
}
