package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

	//instance variables
	private String name;
	private String address;
	private String phoneNumber;
	private List<BankAccount> accounts = new ArrayList<>();
	
	//constructor
	public BankCustomer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	//methods
	public void addAccount(BankAccount newAccount) {
		this.accounts.add(newAccount);
	}
	
	public boolean isVIP() {
		
		DollarAmount holderAmount = new DollarAmount(0);
		
		for(BankAccount element : accounts) {
			holderAmount = holderAmount.plus(element.getBalance());
		}
		
		return holderAmount.isGreaterThanOrEqualTo(new DollarAmount(2500000));
	}
	 
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BankAccount[] getAccounts() {
		
		return accounts.toArray(new BankAccount[accounts.size()]);
	}
}
