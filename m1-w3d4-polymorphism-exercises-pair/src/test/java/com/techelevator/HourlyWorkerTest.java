package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HourlyWorkerTest {
	HourlyWorker sut;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test35Hours() {
		sut = new HourlyWorker("Vail", "Aaron", 10);
		int result = (int)sut.calculateWeeklyPay(35);
		assertEquals(350, result); 
	}
	@Test
	public void testOvertime() {
		sut = new HourlyWorker("Vail", "Aaron", 10);
		int result = (int)sut.calculateWeeklyPay(50);
		assertEquals(450, result); 
	}
	

}
