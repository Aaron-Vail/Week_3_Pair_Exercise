package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {

	BankAccount sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new SavingsAccount();
	}
	
	@Test
	public void testWithdrawMoreThanBalance() {
		DollarAmount dA1 = new DollarAmount(16000);
		DollarAmount dA2 = new DollarAmount(17000);
		
		sut.deposit(dA1);
		sut.withdraw(dA2);
		
		DollarAmount result = sut.getBalance();
		
		assertEquals(dA1, result);
	}
	
	@Test
	public void testWithdraw159() {
		DollarAmount dA1 = new DollarAmount(16000);
		DollarAmount dA2 = new DollarAmount(15900);
		
		sut.deposit(dA1);
		sut.withdraw(dA2);
		
		DollarAmount result = sut.getBalance();
		
		assertEquals(dA1, result);
	}
	
	@Test
	public void testWithdraw158() {
		//tests for withdraw and fee
		
		DollarAmount dA1 = new DollarAmount(16000);
		DollarAmount dA2 = new DollarAmount(15800);
		DollarAmount dA3 = new DollarAmount(0);
		
		sut.deposit(dA1);
		sut.withdraw(dA2);
		
		
		DollarAmount result = sut.getBalance();
		
		assertEquals(dA3, result);
	}
	
	@Test
	public void testWithdraw40From300() {
		//tests for withdraw and fee
		
		DollarAmount dA1 = new DollarAmount(30000);
		DollarAmount dA2 = new DollarAmount(4000);
		DollarAmount dA3 = new DollarAmount(26000);
		
		sut.deposit(dA1);
		sut.withdraw(dA2);
		
		
		DollarAmount result = sut.getBalance();
		
		assertEquals(dA3, result);
	}
	

}
