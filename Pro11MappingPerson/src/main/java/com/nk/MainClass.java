package com.nk;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Address.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Project.class).buildSessionFactory();
		Session session=factory.openSession();
		
		//Begin transaction
		session.beginTransaction();
		
		//Create a new Person
		Person person=new Person();
		person.setName("John Doe");
		
		//Add a address
		Address address=new Address();
		address.setStreet("123 Main Street");
		address.setCity("New York");
		address.setPerson(person);
		
		person.setAddress(address);
		
		//Add Phone
		Phone phone1=new Phone();
		phone1.setNumber("123-456-789");
		phone1.setPerson(person);
		
		Phone phone2=new Phone();
		phone2.setNumber("987-654-321");
		phone2.setPerson(person);
		
		person.setPhones(new ArrayList<>());
		person.getPhones().add(phone1);
		person.getPhones().add(phone2);
		
		
		//Add Projects(many to Many)
		Project project1=new Project();
		project1.setProjectName("Project Alpha");
		
		Project project2=new Project();
		project2.setProjectName("Project Beta");
		
		person.setProjects(new ArrayList<>());
		person.getProjects().add(project1);
		person.getProjects().add(project2);
		
		
		session.save(person);
		session.getTransaction().commit();
		System.out.println("saved successfully");
		
		session.close();
		factory.close();
		
	}
}
