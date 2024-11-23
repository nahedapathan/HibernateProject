package com.tka.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Book;

public class SearchById {

	public void searchbyId(int id)
	{
		SessionFactory sessionFactory=new Configuration().addAnnotatedClass(Book.class).configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Book book=session.get(Book.class,id );
		if(book!=null)
		{
			System.out.println(book);
		}
		else
		{
			System.out.println("Book Does not found");
		}
		
		session.getTransaction().commit();
		session.close();
	
	}
}
