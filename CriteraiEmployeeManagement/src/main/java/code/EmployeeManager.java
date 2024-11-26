package code;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployeeManager {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		
		addEmployees(session);
		
		System.out.println("Displaying Required Data");
		
		System.out.println("Employees with salary greater than 50000: ");
		getEmployeeBySalary(session,5000);
		
		System.out.println("Displaying Required Details: ");
		System.out.println("Employees with specification designation: ");
		getEmployeesByDesignation(session,"Developer");
		System.out.println("success");
		
		session.close();
		session.close();
		
	}


	private static void addEmployees(Session session) {
		
		Transaction tx=session.beginTransaction();
		
		Employees e1=new Employees();
		e1.setName("Doe Plane");
		e1.setDesignation("Manager");
		e1.setSalary(300000);
		
		Employees e2=new Employees();
		e2.setName("Sherdian");
		e2.setDesignation("Developer");
		e2.setSalary(70000);
		
		session.save(e1);
		session.save(e2);
		tx.commit();
		
	}
	

	private static void getEmployeeBySalary(Session session, int salary) {
//		Criteria criteria =session.createCriteria(Employees.class);
//		criteria.add(Restrictions.gt("salary", salary));
//		List<Employees> employees=criteria.list();
//		
//		for(Employees emp:employees)
//		{
//			System.out.println(emp);
//		}
		
		Criteria criteria=session.createCriteria(Employees.class);
		
		criteria.setProjection(Projections.property("designation"));
		
		List<String> employees=criteria.list();
		
		for(String emp:employees)
		{
			System.out.println(emp);
		}
	}
	

	private static void getEmployeesByDesignation(Session session, String designation) {
		Criteria criteria=session.createCriteria(Employees.class);
		
		criteria.add(Restrictions.eq("designation", designation));
		
		List<Employees> employees=criteria.list();
		for(Employees emp:employees)
		{
			System.out.println(emp);
		}
		
	}
	
	
}
