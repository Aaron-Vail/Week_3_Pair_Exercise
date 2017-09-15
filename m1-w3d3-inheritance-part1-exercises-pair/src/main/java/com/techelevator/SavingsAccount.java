package com.techelevator;

public class SavingsAccount extends BankAccount {

	private String accountType = "Savings";
	
	@Override
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		
		//If you have $160 and request a withdraw of $170 - no withdraw happens
		if(getBalance().minus(amountToWithdraw).isLessThan(new DollarAmount(0))) {
			return getBalance();
		}
		
		//If you have $160 and request a withdraw of $159 or more, because of fee, no withdraw happens 
		if(getBalance().minus(amountToWithdraw.plus(new DollarAmount(200))).isLessThan(new DollarAmount(0))) {
			return getBalance();
		}
		
		//withdraw
		super.withdraw(amountToWithdraw);
		
		//if balance after withdraw is less than $150, do withdraw and subtract fee from balance
		if(getBalance().minus(amountToWithdraw).isLessThan(new DollarAmount(15000))) {
			super.withdraw(new DollarAmount(200));
			return getBalance();
		}

//		if balance is below $150.00 before the withdraw		
//		if(getBalance().isLessThan(new DollarAmount(15000))) {
//		return getBalance().minus(amountToWithdraw.plus(new DollarAmount(200)));
//	}
		
		//if balance after is greater than or equal to $150, do withdraw and return balance
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
