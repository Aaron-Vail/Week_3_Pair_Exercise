package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

	BankAccount sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new CheckingAccount();
	}

	@Test
	public void testWithdraw() {
		DollarAmount dA1 = new DollarAmount(500);
		DollarAmount dA2 = new DollarAmount(300);
		
		sut.deposit(dA1);
		sut.withdraw(dA2);
		
		DollarAmount result = sut.getBalance();
		
		assertEquals(dA1.minus(dA2), result);
	}
	
	@Test
	public void testOverdraft() {
		DollarAmount dA1 = new DollarAmount(500);
		DollarAmount dA2 = new DollarAmount(600);
		DollarAmount fee = new DollarAmount(1000);
		
		sut.deposit(dA1);
		sut.withdraw(dA2);
		
		DollarAmount result = sut.getBalance();
		
		assertEquals(dA1.minus(dA2).minus(fee), result);
	}
	
	@Test
	public void testNegative100() {
		DollarAmount dA1 = new DollarAmount(500);
		DollarAmount dA2 = new DollarAmount(13000);
		
		sut.deposit(dA1);
		sut.withdraw(dA2);
		
		DollarAmount result = sut.getBalance();
		
		assertEquals(dA1, result);
	}

}
