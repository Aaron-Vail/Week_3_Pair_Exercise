package com.techelevator;

public class HourlyWorker implements Worker {
	
	private String firstName;
	private String lastName;
	private double hourlyRate;
	private int hoursWorked;

	
	public HourlyWorker(String lastName, String firstName, double hourlyRate) {
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.hourlyRate = hourlyRate;
	}
	
	public double calculateWeeklyPay(int hoursWorked) {
		
		this.hoursWorked = hoursWorked;
		double overtime = (hoursWorked - 40);
		
		if (hoursWorked <= 40) {
			return hoursWorked * hourlyRate;
		} else {
			return ((hourlyRate * 40) + (hourlyRate * overtime * .5));
		}		
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}
	
	@Override
	public String toString() {
		return String.valueOf(Math.round(calculateWeeklyPay(getHoursWorked()))) + ".00";
	}
	
	
}
