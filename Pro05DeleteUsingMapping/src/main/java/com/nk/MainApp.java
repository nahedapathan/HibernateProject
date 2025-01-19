package com.nk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory sessionfactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		
		Student student=session.get(Student.class,5);
		if(student!=null)
		{
			session.delete(student);
			System.out.println("User Delete Successfully");
		}
		else
		{
			System.out.println("Student not found");
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
}
