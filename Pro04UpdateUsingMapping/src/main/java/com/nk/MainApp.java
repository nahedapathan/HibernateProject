package com.nk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory sessionfactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		Student updateStudent=session.get(Student.class, 1);
		if(updateStudent !=null)
		{
			updateStudent.setName("Rajesh");
			System.out.println("Data Updated Successfully!");
		}
		else
		{
			System.out.println("User not found");
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
}
