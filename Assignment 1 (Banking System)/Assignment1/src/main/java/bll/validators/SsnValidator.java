package bll.validators;

import javax.swing.JOptionPane;
import model.Client;

public class SsnValidator implements Validator<Client> {

	public void validate(Client c) {

		if (c.getSsn().length() != 13) {
			JOptionPane.showMessageDialog(null, "Not a valid SSN!");
			throw new IllegalArgumentException("The client ssn structure is not respected!");
		}
	}
}
