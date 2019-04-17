package model;

import javax.swing.JOptionPane;

public class Account {
	
	private String accountNumber;
	private String type;
	private double balance;
	private String creationDate;
	private String ownerSSN;

	private boolean ok = false;

	public Account(String accNo, double balance, String ownerSSN, String type, String creationDate) {
		accountNumber = accNo;
		this.ownerSSN = ownerSSN;
		this.balance = balance;
		this.type = type;
		this.creationDate = creationDate;
	}
	
	public Account() {
		
	}
	
	// AICI POT FACE SA RETURNEZE VOID SI SA SETEZE DIRECT DE AICI BALANCEUL NOU
	// PLUS SA SCOT ASTEA CU > 1000 SI SA VAD CUM SCAP DE OK
	public void deposit(double depositAmount) {
			balance += depositAmount;
			this.setBalance(balance);
	}

	public void withdraw(double withdrawAmount) {
		if (withdrawAmount > this.balance) {
			 JOptionPane.showMessageDialog(null, "Not enough amount of money in the account!");
		} 
		balance -= withdrawAmount;
		this.setBalance(balance);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public double getBalance() {
		return balance;
	}

	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerSSN() {
		return ownerSSN;
	}

	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}

	public void setBalance(double balance) {
		if(! (this.balance == balance)) {
	         System.out.println("Value changed to new value: "+ balance);
	         this.balance = balance;
	      }
		
	}

	
	

}
