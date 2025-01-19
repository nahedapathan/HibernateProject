package com.read;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReadAllUsingForEach {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		try(SessionFactory sessionfactory=cfg.buildSessionFactory()) {
			
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		Query<Student> query=session.createQuery("from Student");
		List<Student> l=query.list();
		
		for(Student s:l)
		{
			System.out.println(s);
		}
		
		session.getTransaction().commit();
		session.close();
        sessionfactory.close();
		
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
