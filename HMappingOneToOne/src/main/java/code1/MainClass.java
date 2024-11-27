package code1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Faculty.class).addAnnotatedClass(FacultySubject.class).buildSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		//Create Subject
		FacultySubject fsub=new FacultySubject();
		fsub.setSname("Computer");
		
		//Create Faculty
		Faculty faculty=new Faculty();
		faculty.setFname("Priya");
		faculty.setFacultysubject(fsub);
		
		session.save(faculty);
		session.getTransaction().commit();
		
		System.out.println("Data Saved ");
		session.close();
		factory.close();
		
	}

}
