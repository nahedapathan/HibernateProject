package com.nk;

public class MainApp {

	public static void main(String[] args) {
		// Add Employee
		EmployeeService service = new EmployeeService();

		service.addEmployee("Naheda", "IT", 1000);
		service.addEmployee("Ram", "IT", 1000);
		service.addEmployee("Sham", "IT", 1000);
		service.addEmployee("Den", "IT", 1000);
		service.addEmployee("Pintu", "IT", 1000);
		service.addEmployee("Dambo", "IT", 1000);

		// Fetch all Employee
		System.out.println("Display all Employee:");
		for (Employee emp : service.getAllEmployee()) {
			System.out.println(emp);
		}

		// delete Employee
		service.deleteEmployee(3);

		// Fetch all Employee
		System.out.println("Display all Employee:");
		for (Employee emp : service.getAllEmployee()) {
			System.out.println(emp);
		}

		// Update Emp
		service.updateEmployee(2, 880);

		// Fetch all Employee
		System.out.println("Display all Employee:");
		for (Employee emp : service.getAllEmployee()) {
			System.out.println(emp);
		}
	}
}
