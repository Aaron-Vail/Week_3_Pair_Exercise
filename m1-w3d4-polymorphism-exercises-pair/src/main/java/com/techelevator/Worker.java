package com.techelevator;

public interface Worker {
	public String getFirstName();
	public String getLastName();
	public int getHoursWorked();
	public double calculateWeeklyPay(int hoursWorked);
	
}
