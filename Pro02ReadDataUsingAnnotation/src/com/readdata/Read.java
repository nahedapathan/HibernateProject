package com.readdata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Read {
   public static void main(String[] args) {
	//1.Load Configuration
	   Configuration cfg=new Configuration();
	   cfg.configure("resources/hibernate.cfg.xml");
	   cfg.addAnnotatedClass(Student.class);
	   
	   try(SessionFactory sessionfactory=cfg.buildSessionFactory())
	   {
		   Session session=sessionfactory.openSession();
		   
		   session.beginTransaction();
		   
		   Student student=session.get(Student.class, 1);
		   System.out.println(student);
		   
		   session.getTransaction().commit();
		   
		   session.close();
		   sessionfactory.close();
	   }
	   
	   
	   
}
}
