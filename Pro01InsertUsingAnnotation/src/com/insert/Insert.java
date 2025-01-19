package com.insert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Insert {
   public static void main(String[] args) {
	//1.Load Configuration
	   Configuration cfg=new Configuration();
	   cfg.configure("resources/hibernate.cfg.xml");
	   cfg.addAnnotatedClass(Student.class);
	   
	 try(SessionFactory sessionFactory=cfg.buildSessionFactory())
	 {
		 Session session=sessionFactory.openSession();
		 
		 Student s1=new Student();
		 s1.setId(2);
		 s1.setName("Priya");
		 s1.setAge(22);
		 s1.setCity("Latur");
		 
		 session.beginTransaction();
		 session.save(s1);
		 session.getTransaction().commit();
		 
		 
		 //close connection
		 session.close();
		 sessionFactory.close();
		 
	 }catch (Exception e) {
		System.out.println(e);
	}
	 
}
}
