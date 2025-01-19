package com.nk;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmployeeService {

	
	//Create
	public void createEmployee(Session session,Employee employee)
	{
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		System.out.println("Employee Created Successfully!");
	}
	
	//Read
	public List<Employee> readEmployee(Session session)
	{
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Employee> query=builder.createQuery(Employee.class);
		Root<Employee> root=query.from(Employee.class);
		query.select(root);
		
		return session.createQuery(query).getResultList();
	}
	
	
	//Update 
	public void updateEmployee(Session session,int employeeId,double newSalary)
	{
		Transaction tx=session.beginTransaction();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaUpdate<Employee> update=builder.createCriteriaUpdate(Employee.class);
		Root<Employee> root=update.from(Employee.class);
		
		update.set("salary", newSalary);
		update.where(builder.equal(root.get("id"), employeeId));
		
		session.createQuery(update).executeUpdate();
		tx.commit();
		
		System.out.println("Employee Updated Successfully!");
	}
	
	
	//Delete
	public void deleteEmployee(Session session,int employeeId)
	{
		Transaction tx=session.beginTransaction();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaDelete<Employee> delete=builder.createCriteriaDelete(Employee.class);
		Root<Employee> root=delete.from(Employee.class);
		
		delete.where(builder.equal(root.get("id"), employeeId));
		
		session.createQuery(delete).executeUpdate();
		tx.commit();
		System.out.println("Employee Deleted Successfully");
	}
	
	
	public static void getEmployeeBySalary(Session session,double salary)
	{
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Employee> query=builder.createQuery(Employee.class);
		Root<Employee> root=query.from(Employee.class);
		query.select(root).where(builder.gt(root.get("salary"), 50000));
		
		List<Employee> emp=session.createQuery(query).getResultList();
		
		for(Employee employee:emp)
		{
			System.out.println(employee);
		}
		
	}
}
