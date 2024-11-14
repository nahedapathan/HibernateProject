package ent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

	public static void main(String[] args) {
		//Step 1:Set up hibernate and get a session factory
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Step 2
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("Connection Success");
		User newUser=new User();
		newUser.setId(1);
		newUser.setName("Nahed");
		newUser.setEmail("nk@g.com");
		
		session.save(newUser);
		session.getTransaction().commit();
		session.close();
		System.out.println("User has been added to the database");
		
		sessionFactory.close();
		System.out.println("BYE bye");
		
	}
}
