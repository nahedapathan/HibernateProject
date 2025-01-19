package com.nk;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmployeeService {

	// Step 1:Intitialize sessionFactory
	private static SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

	// Step 2:Insert Data
	public void addEmployee(String name, String department, double salary) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();

		// create a new eMPLOYEE
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDepartment(department);
		employee.setSalary(salary);
		session.save(employee);

		tx.commit();
		session.close();
	}

	// Step 3:Fetch Data
	public List<Employee> getAllEmployee() {
		Session session = sessionfactory.openSession();
		String hql = "from Employee";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> employees = query.getResultList();
		session.close();

		return employees;
	}

	// Step 4:Delete Employee
	public void deleteEmployee(int empId) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "Delete from Employee e where e.id= :employeeId";
		Query query = session.createQuery(hql);
		query.setParameter("employeeId", empId);
		query.executeUpdate();

		tx.commit();
		session.close();
		System.out.println("Employee has been Deleted");
	}

	// Step 5:Update Employee Using ID;
	public void updateEmployee(int empId, double salary) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "UPDATE Employee set salary= :salary WHERE id= :employee_id";
		Query query = session.createQuery(hql);
		query.setParameter("salary", salary);
		query.setParameter("employee_id", empId);

		query.executeUpdate();
		tx.commit();
		session.close();
		System.out.println("Updated Successfully!");

	}

}
