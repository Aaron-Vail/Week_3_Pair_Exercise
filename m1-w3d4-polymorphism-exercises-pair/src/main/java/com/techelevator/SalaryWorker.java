package com.techelevator;

public class SalaryWorker implements Worker {
	private String firstName;
	private String lastName;
	private double annualSalary;
	private int hoursWorked;
	
	public SalaryWorker(String lastName, String firstName, double annualSalary) {
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.annualSalary = annualSalary;
		
	}
	
	public double calculateWeeklyPay(int hoursWorked) {
		this.hoursWorked = hoursWorked;
		return annualSalary / 52;
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
