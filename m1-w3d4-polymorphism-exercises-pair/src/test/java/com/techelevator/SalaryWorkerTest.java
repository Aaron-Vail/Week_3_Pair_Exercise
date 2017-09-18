package com.techelevator;

	
public class SalaryWorkerTest {
	SalaryWorker sut;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testZeroSalary() {
		sut = new SalaryWorker("Vail", "Aaron", 0);
		int result = (int)sut.calculateWeeklyPay(50);
		assertEquals(0, result); 
	}
	@Test
	public void testFiftyGrandSalary() {
		sut = new SalaryWorker("Vail", "Aaron", 52000);
		int result = (int)sut.calculateWeeklyPay(40);
		assertEquals(1000, result); 
	}

}
