package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	BankAccount sut1;
	BankAccount sut2;
	
	@Before
	public void setUp() throws Exception {
		sut1 = new BankAccount();
		sut2 = new BankAccount();
	}

	@Test
	public void testDeposit() {
		DollarAmount sutA = new DollarAmount(500);
		DollarAmount sutB = new DollarAmount(1000);
		
		sut1.deposit(sutA);
		sut2.deposit(sutB);
		
		DollarAmount result1 = sut1.getBalance();
		DollarAmount result2 = sut2.getBalance();
		
		assertEquals(sutA, result1);
		assertEquals(sutB, result2);
		
	}
	
	@Test
	public void testWithdraw() {
		DollarAmount sutA = new DollarAmount(500);
		DollarAmount sutB = new DollarAmount(1000);
		DollarAmount sutC = new DollarAmount(250);
		DollarAmount sutD = new DollarAmount(350);
		
		sut1.deposit(sutA);
		sut2.deposit(sutB);
		sut1.withdraw(sutC);
		sut2.withdraw(sutD);
		
		DollarAmount result1 = sut1.getBalance();
		DollarAmount result2 = sut2.getBalance();
		
		assertEquals(sutA.minus(sutC), result1);
		assertEquals(sutB.minus(sutD), result2);
		
	}
	
	@Test
	public void testTransfer() {
		DollarAmount sutA = new DollarAmount(500);
		DollarAmount sutB = new DollarAmount(1000);
		DollarAmount sutC = new DollarAmount(350);
		
		sut1.deposit(sutA);
		sut2.deposit(sutB);
		
		sut2.transfer(sut1, sutC);
		
		DollarAmount result1 = sut1.getBalance();
		DollarAmount result2 = sut2.getBalance();
		
		assertEquals(sutA.plus(sutC), result1);
		assertEquals(sutB.minus(sutC), result2);
		
	}

}
