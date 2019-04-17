package bll.validators;

import javax.swing.JOptionPane;

import model.Account;

public class AccountNoValidator implements Validator<Account> {

	public void validate(Account a) {

		if (a.getAccountNumber().length() < 12 || a.getAccountNumber().length() > 12) {
			JOptionPane.showMessageDialog(null, "Not a valid account number!");
			throw new IllegalArgumentException("The account number must have 24 characters!");
		}
	}

}
