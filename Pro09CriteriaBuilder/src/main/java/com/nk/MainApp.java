package com.nk;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		
		EmployeeService system=new EmployeeService();
		system.getEmployeeBySalary(session, 50000);
		
		//Create
		Employee emp=new Employee();
		emp.setName("John");	
		emp.setDepartment("IT");
		emp.setSalary(60000);
		
		system.createEmployee(session, emp);
		
		
		//Read Employee
		List<Employee> employees=system.readEmployee(session);
		employees.forEach(e->System.out.println(e));
	
		
		//Update Employee
		system.updateEmployee(session, 1, 700000);
		
		//Delete Employee
		system.deleteEmployee(session, 1);
	}
}
