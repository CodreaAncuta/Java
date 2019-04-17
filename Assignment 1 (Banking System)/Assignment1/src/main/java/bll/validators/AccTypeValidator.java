package bll.validators;

import javax.swing.JOptionPane;

import model.Account;
public class AccTypeValidator implements Validator<Account> {

		public void validate(Account a) {

			if (a.getType().equals("Saving Account") || a.getType().equals("Spending Account")) {
			
			}
			else {
				JOptionPane.showMessageDialog(null, "Not a valid SSN!");
				throw new IllegalArgumentException("The client ssn structure is not respected!");
			}
		}
}
