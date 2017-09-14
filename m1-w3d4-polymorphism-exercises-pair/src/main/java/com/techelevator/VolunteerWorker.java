package com.techelevator;

public class VolunteerWorker implements Worker {
	
	private String firstName;
	private String lastName;
	private int hoursWorked;
	
	public VolunteerWorker(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public double calculateWeeklyPay(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	
		double pay = 0;
		pay = hoursWorked * 0;
		return pay;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}
	
	@Override
	public String toString() {
		return String.valueOf(Math.round(calculateWeeklyPay(getHoursWorked()))) + ".00";
	}

}
