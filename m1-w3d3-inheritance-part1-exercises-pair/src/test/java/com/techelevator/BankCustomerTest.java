package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankCustomerTest {
	
	BankCustomer sut;
	
	BankAccount checking;
	
	BankAccount savings;
	
	BankAccount savings2;
	
	@Before
	public void setUp() throws Exception {
		
		sut = new BankCustomer("Bobby Dorrance", "123 Awesome Lane", "216-555-1234");
		
		checking = new CheckingAccount();
		
		savings = new SavingsAccount();
		
		savings2 = new SavingsAccount();
		
	}

	@Test
	public void testAddCheckingAccount() {
		
		sut.addAccount(checking);
		
		boolean result = (sut.getAccounts().length == 1);
		
		assertEquals(true, result);
		
		boolean result2 = (checking.getAccountType() == "Checking");
		
		assertEquals(true, result2);	
	}
	
	@Test
	public void testAddSavingsAccount() {
		
		sut.addAccount(savings);
		
		boolean result = (sut.getAccounts().length == 1);
		
		assertEquals(true, result);
		
		boolean result2 = (savings.getAccountType() == "Savings");
		
		assertEquals(true, result2);	
	}

	@Test
	public void testAddBothAccounts() {
		
		sut.addAccount(checking);
		sut.addAccount(savings);
		
		boolean result = (sut.getAccounts().length == 2);
		
		assertEquals(true, result);
		
		boolean result2 = (checking.getAccountType() == "Checking" && savings.getAccountType() == "Savings");
		
		assertEquals(true, result2);	
	}
	
	@Test
	public void testCheckingDepositAndWithdraw() {
		
		sut.addAccount(checking);
		
		checking.deposit(new DollarAmount(50000));
		
		DollarAmount result = checking.getBalance();
		
		assertEquals(new DollarAmount(50000), result);
		
		checking.withdraw(new DollarAmount(26000));
		
		DollarAmount result2 = checking.getBalance();
		
		assertEquals(new DollarAmount(24000), result2);	
	}
	
	@Test
	public void testTransferFromCheckingToSavings() {
		
		sut.addAccount(checking);
		sut.addAccount(savings);
		
		checking.deposit(new DollarAmount(50000));
		
		checking.transfer(savings, new DollarAmount(30000));
		
		DollarAmount result = checking.getBalance();
		DollarAmount result2 = savings.getBalance();
		
		assertEquals(new DollarAmount(20000), result);
		assertEquals(new DollarAmount(30000), result2);	
	}
	
	@Test
	public void testVIP() {
		
		sut.addAccount(checking);
		sut.addAccount(savings);
		//20 thousand
		checking.deposit(new DollarAmount(2000000));
		//7 thousand
		savings.deposit(new DollarAmount(700000));
		
		
		DollarAmount totalBalanceHolder = new DollarAmount(0);
		for (BankAccount element : sut.getAccounts()) {
			totalBalanceHolder = totalBalanceHolder.plus(element.getBalance());
		}
		
		boolean result = sut.isVIP();
		
		assertEquals(true, result);
	}
	
	@Test
	public void testNotVIP() {
		
		sut.addAccount(checking);
		sut.addAccount(savings);
		//20 thousand
		checking.deposit(new DollarAmount(2000000));
		//4 thousand
		savings.deposit(new DollarAmount(400000));
		
		
		DollarAmount totalBalanceHolder = new DollarAmount(0);
		for (BankAccount element : sut.getAccounts()) {
			totalBalanceHolder = totalBalanceHolder.plus(element.getBalance());
		}
		
		boolean result = sut.isVIP();
		
		assertEquals(false, result);
	}
	
	@Test
	public void testReturnsAnArrayOfAccounts() {
		
		sut.addAccount(checking);
		sut.addAccount(savings);
		sut.addAccount(savings2);
	
		boolean result1 = sut.getAccounts()[0].equals(checking);
		boolean result2 = sut.getAccounts()[1].equals(savings);
		boolean result3 = sut.getAccounts()[2].equals(checking);
		
		assertEquals(true, result1);
		assertEquals(true, result2);
		assertEquals(false, result3);
	}
	
}
