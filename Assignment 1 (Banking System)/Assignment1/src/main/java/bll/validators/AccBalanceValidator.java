package bll.validators;

import javax.swing.JOptionPane;

import model.Account;

public class AccBalanceValidator implements Validator<Account> {

	public void validate(Account a) {

		if (a.getBalance() < 0.0) {
			JOptionPane.showMessageDialog(null, "Not a valid amount!");
			throw new IllegalArgumentException("The amount can't be lower than 0.0!");
		}
	}
}
