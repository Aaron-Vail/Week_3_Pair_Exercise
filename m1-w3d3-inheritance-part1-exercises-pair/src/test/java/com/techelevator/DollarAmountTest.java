package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DollarAmountTest {

	@Test
	public void test3210() {
		DollarAmount sut = new DollarAmount(3210);
		String result = sut.toString();
		assertEquals("$32.10", result);
	}
	
	@Test
	public void test1000() {
		DollarAmount sut = new DollarAmount(1000);
		String result = sut.toString();
		assertEquals("$10.00", result);
	}
	
	@Test
	public void test1() {
		DollarAmount sut = new DollarAmount(1);
		String result = sut.toString();
		assertEquals("$0.01", result);
	}
	
	@Test
	public void test807() {
		DollarAmount sut = new DollarAmount(807);
		String result = sut.toString();
		assertEquals("$8.07", result);
	}
	
	@Test
	public void testNegative3210() {
		DollarAmount sut = new DollarAmount(-3210);
		String result = sut.toString();
		assertEquals("-$32.10", result);
	}
	
	@Test
	public void testNegative1000() {
		DollarAmount sut = new DollarAmount(-1000);
		String result = sut.toString();
		assertEquals("-$10.00", result);
	}
	
	@Test
	public void testNegative1() {
		DollarAmount sut = new DollarAmount(-1);
		String result = sut.toString();
		assertEquals("-$0.01", result);
	}
	
	@Test
	public void testNegative807() {
		DollarAmount sut = new DollarAmount(-807);
		String result = sut.toString();
		assertEquals("-$8.07", result);
	}

}
