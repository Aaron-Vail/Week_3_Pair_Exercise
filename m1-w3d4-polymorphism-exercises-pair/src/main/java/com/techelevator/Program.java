package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		SalaryWorker aaronVail = new SalaryWorker("Vail", "Aaron", 55000);
		SalaryWorker bobbyDorrance = new SalaryWorker("Dorrance", "Bobby", 15000);
		HourlyWorker franciscoLindor = new HourlyWorker("Lindor", "Francisco", 5000);
		HourlyWorker leBronJames = new HourlyWorker("James", "LeBron", 10000);
		VolunteerWorker joeErickson = new VolunteerWorker("Erickson", "Joe");
		VolunteerWorker joshTucholski = new VolunteerWorker("Tucholski", "Josh");
		
		List<Worker> workerList = new ArrayList<>();
		
		workerList.add(aaronVail);
		workerList.add(bobbyDorrance);
		workerList.add(franciscoLindor);
		workerList.add(leBronJames);
		workerList.add(joeErickson);
		workerList.add(joshTucholski);

		int hourHolder = 0;
		double payHolder = 0;
		
		System.out.format("%-15s %-15s %-15s %-20s%n", "Last", "First", "Hours", "Weekly Pay");
		System.out.println("-----------------------------------------------------------");
		
		for(Worker element : workerList) {
			element.calculateWeeklyPay((int)Math.round(Math.random() * 100 + 1));
			
			hourHolder += element.getHoursWorked();
			payHolder += element.calculateWeeklyPay(element.getHoursWorked());
			
			//System.out.format("%-15s %-15s %-15d %-1s %-20d%n",element.getLastName(),element.getFirstName(),element.getHoursWorked(),"$",Math.round(element.calculateWeeklyPay(element.getHoursWorked())));
			System.out.format("%-15s %-15s %-15d %-1s%n",element.getLastName(),element.getFirstName(),element.getHoursWorked(),"$"+ element.toString());
		}

			
		System.out.println("-----------------------------------------------------------");
		System.out.println('\n'+"Total Hours: " + hourHolder);
		System.out.println("Total Pay: " + "$" + Math.round(payHolder) + ".00");

		

	}

}
