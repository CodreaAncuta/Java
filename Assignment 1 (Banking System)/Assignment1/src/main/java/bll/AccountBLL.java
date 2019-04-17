package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.AccBalanceValidator;
import bll.validators.AccTypeValidator;
import bll.validators.AccountNoValidator;
import bll.validators.Validator;
import dao.AccountGateway;
import model.Account;

public class AccountBLL {
	private List<Validator<Account>> validators;

	public AccountBLL() {
		validators = new ArrayList<Validator<Account>>();
		validators.add(new AccTypeValidator());
		validators.add(new AccBalanceValidator());
		validators.add(new AccountNoValidator());
	}

	public int add(Account acc) {
		for (Validator<Account> v : validators) {
			v.validate(acc);
		}
		return AccountGateway.add(acc);
	}

	public Account viewInfoAccount(String accNumber) {

		Account acc = AccountGateway.viewInfoAccount(accNumber);
		if (acc == null) {
			throw new NoSuchElementException("The account having the accNumber = " + accNumber + " was not found!");
		}
		return acc;
	}

	public String viewAccountNumber(String ownerSSN) {

		String accNo = AccountGateway.viewAccountNumber(ownerSSN);
		if (accNo == null) {
			throw new NoSuchElementException("The accountNumber corresponding to the SSN = " + ownerSSN + " was not found!");
		}
		return accNo;
	}

	public int update(Account acc) {
		for (Validator<Account> v : validators) {
			v.validate(acc);
		}
		return AccountGateway.update(acc);
	}

	public void delete(String accNo) {
		AccountGateway.delete(accNo);
	}
	
	public static List<Account> findAll(String ownerSSN) {
		return AccountGateway.findAll(ownerSSN);
	}
}
