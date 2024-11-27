package code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class).buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		//create a Passport
		Passport passport=new Passport();
		passport.setPassportNumber("p213456");
		passport.setCountry("India");
		
		
		
		//Create a Person
		Person person=new Person();
		person.setName("jesh");
		person.setAge(21);
		person.setPassport(passport);
		
		session.save(person);
		session.getTransaction().commit();
		
		System.out.println("Data Save Succesfully");
		session.close();
		factory.close();
	}
}
