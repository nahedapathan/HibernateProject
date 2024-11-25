package code;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmployeeService {

	//Step 1:Initialize sessionFactory
	private static  SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	//Step 2:Method to add employee
	public void addEmployee(String name,String department,double salary)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//create a new eMPLOYEE
		Employee employee=new Employee();
		employee.setName(name);
		employee.setDepartment(department);
		employee.setSalary(salary);
		
		session.save(employee);
		tx.commit();
		session.close();
	}
	
   //Step 3:method to fetch employees
	public List<Employee> getAllEmployee()
	{
		Session session=sessionFactory.openSession();
		String hql="FROM Employee";
		Query<Employee> query=session.createQuery(hql,Employee.class);
		List<Employee> employees=query.getResultList();
		session.close();
		return employees;
		
	}
	
	//step 4:Delete Employee
	public void deleteEmployee(int employeeId)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Delete from Employee e where e.id= :employeeId";
		Query query=session.createQuery(hql);
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();
		
		tx.commit();
		session.close();
		System.out.println("Employee has been deleted ");
		
	}
	
	
	public static void main(String[] args) {
		EmployeeService service=new EmployeeService();
		
		//Add Employee
		service.addEmployee("Alice", "IT", 980);
		
		
		//Fetch all Employee
		System.out.println("Displaying Employees :");
		for(Employee emp:service.getAllEmployee())
		{
			System.out.println(emp);
		}
		
		service.deleteEmployee(5);
	}
}

















