package com.techelevator;

public class BankAccount {
	
		//instance variables
		private String accountNumber;
		private DollarAmount balance = new DollarAmount(0);
		private String accountType;
		
		//constructor
		public BankAccount() {
			
		}
		
		//methods
		public DollarAmount deposit(DollarAmount amountToDeposit) {
			this.balance = balance.plus(amountToDeposit);
			return balance;
		}
		
		public DollarAmount withdraw(DollarAmount amountToWithdraw) {
			this.balance = balance.minus(amountToWithdraw);
			return balance;
		}
		
		public void transfer(BankAccount destinationAccount, DollarAmount transferAmount) {
			this.withdraw(transferAmount);
			destinationAccount.deposit(transferAmount);
		}
		
		//getters and setters
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public DollarAmount getBalance() {
			return balance;
		}
		
		public String getAccountType() {
			return accountType;
		}
		
		@Override
		public String toString() {
			return accountType;
		}
		
}
