package com.read;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReadAllUsingIterator {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		try(SessionFactory sessionfactory=cfg.buildSessionFactory())
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			
			//HQL
			Query query=session.createQuery("from Student");
			List l=query.list();
			Iterator itr=l.iterator();
			
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
			
			
			session.getTransaction().commit();
			session.close();
			sessionfactory.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
