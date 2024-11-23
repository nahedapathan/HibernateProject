package com.tka.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Book;

public class BookDemo {

	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.addAnnotatedClass(Book.class);
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		//Book b=new Book("Wings OF Fire","APJ kalam","Autobiography",390);
		Book b=new Book();
		b.setBname("Dictonary");
		b.setBauthor("BJames");
		b.setCategory("DSelf Help");
		b.setPrice(100);
				
				
		session.save(b);
		tx.commit();
		System.out.println("Book Added");
		
		
		
		
	}
}
