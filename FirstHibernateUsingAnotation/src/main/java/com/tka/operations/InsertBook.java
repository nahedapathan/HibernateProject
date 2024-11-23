package com.tka.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Book;

public class InsertBook {

	public void insertBook(Book b)
	{
		SessionFactory sessionFactory=new Configuration().addAnnotatedClass(Book.class).configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(b);
		session.getTransaction().commit();
		session.close();
		System.out.println("Book record inserted successfully");
	}
	
}
