package com.techelevator;

public class CheckingAccount extends BankAccount {
	
	private String accountType = "Checking";
	
	@Override
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		
		if(getBalance().minus(amountToWithdraw).isLessThan(new DollarAmount(-10000))) {
			return getBalance();
		}
		
		super.withdraw(amountToWithdraw);
		
		if(getBalance().isLessThan(new DollarAmount(0))) {
			super.withdraw(new DollarAmount(1000));
		}
		
		return getBalance();
		
	}

	public String getAccountType() {
		return accountType;
	}

	@Override
	public String toString() {
		return accountType;
	}
	
	
	
}
