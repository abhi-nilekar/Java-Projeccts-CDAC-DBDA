package core;

import java.io.Serializable;
import java.time.LocalDate;

public class BankAccount implements Serializable {

	
	private int AccountNumber;
	private String customerName;
	private double balance;
	private AccountType accountType;
	private LocalDate accountCreateDate;
	
	//constructors 
	public BankAccount(int accountNumber, String customerName, double balance, AccountType accountType,
			LocalDate accountCreateDate) {
		super();
		AccountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
		this.accountType = accountType;
		this.accountCreateDate = accountCreateDate;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public LocalDate getAccountCreateDate() {
		return accountCreateDate;
	}

	public void setAccountCreateDate(LocalDate accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}

	@Override
	public String toString() {
		return "BankAccount [AccountNumber=" + AccountNumber + ", customerName=" + customerName + ", balance=" + balance
				+ ", accountType=" + accountType + ", accountCreateDate=" + accountCreateDate + "]";
	}
	
	
	
}
