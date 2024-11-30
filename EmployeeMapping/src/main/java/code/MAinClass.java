package code;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MAinClass {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Project.class).buildSessionFactory();
		
		Session session=factory.openSession();
		
		session.beginTransaction();
		
		//Create Employee
		Employee employee=new Employee();
		employee.setName("Naheda");
		
		//Create Department
		Department department=new Department();
		department.setName("Software");
		department.setEmployee(employee);
		
		employee.setDepartment(department);
		
		//Create phone
		Phone phone1=new Phone();
		phone1.setNumber("987654321");
		phone1.setEmployee(employee);
		
		
		Phone phone2=new Phone();
		phone2.setNumber("3216549871");
		phone2.setEmployee(employee);
		
		
		employee.setPhone(new ArrayList<>());
		employee.getPhone().add(phone1);
		employee.getPhone().add(phone2);
		
		//MAny to MAny
		Project project1=new Project();
		project1.setName("Library Management");
		
		Project project2=new Project();
		project2.setName("School payment");
		
		employee.setProject(new ArrayList<>());
		employee.getProject().add(project1);
		employee.getProject().add(project2);
		
		
		session.save(employee);
		session.getTransaction().commit();
		System.out.println("Saved successfully");
		
		session.close();
		factory.close();
		
	}
}




















