package com.nk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		//Configure Hibernate and Build sessionFactory
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		
		StudentService service=new StudentService();
		
		try {
			service.addStudent(session, new Student(1,"abc",85,"Computer"));
			service.addStudent(session, new Student(2,"def",72,"Computer"));
			service.addStudent(session, new Student(3,"wer",40,"Accounts"));
			service.addStudent(session, new Student(4,"xyz",95,"Accounts"));
			
			//Display all Student
			System.out.println("\nAll Student: ");
			service.displayAllStudent(session);
			
			 // Display Students With Marks > 70
			System.out.println("\nStudents With Marks >70: ");
			service.displayStudentsWithMarksGreaterThan(session, 70);
			
			//Display Student with MaxMarks
			System.out.println("\nStudent with Max Marks: ");
			service.displayStudentWithMarks(session);
			
			
			//Update a Student
			System.out.println("\n Updating Student with Id.....");
			service.updateStudent(session, 2, "naheda", 75, "Math");
			
			//Delete Student
			System.out.println("\n Deleting Student with id 3");
			service.deleteStudent(session, 3);
			
			//Display all Student
			System.out.println("\nAll Student: ");
			service.displayAllStudent(session);
			
		}finally {
			session.close();
			sessionfactory.close();
		}
	}
}
