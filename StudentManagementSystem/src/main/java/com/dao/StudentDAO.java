package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class StudentDAO {

	public void addStudent(Student student)
	{
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student);
		session.getTransaction().commit();
		System.out.println("Student data Added");
		session.close();
		
		sessionFactory.close();
		
	}
	
	public void updateStudent(int studentId, Student uStudent )
	{
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Student updateStudent=session.get(Student.class, studentId);
		if(updateStudent!=null)
		{
			updateStudent.setName(uStudent.getName());
			updateStudent.setAge(uStudent.getAge());
			updateStudent.setEmail(uStudent.getEmail());
			updateStudent.setGrade(uStudent.getGrade());
			System.out.println("Data Updated Successfully");
		}
		else
		{
			System.out.println("Student not found for Updation");
		}
		session.saveOrUpdate(updateStudent);
		session.getTransaction().commit();
	}
	
	
	public void deleteStudent(int studentId)
	{
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Student student=session.get(Student.class, studentId);
		if(student!=null)
		{
			session.delete(student);
			System.out.println("Student Deleted");
			
		}
		else
		{
			System.out.println("Student not found ");
		}
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
	
	
	public void getStudentByID(int studentId)
	{
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Student student=session.get(Student.class,studentId);
		if(student !=null)
		{
			System.out.println(student);
		}
		else
		{
			System.out.println("Student not Found !");
		}
        session.close();
		
		sessionFactory.close();
	}
	
	
	public void getAllStudent()
	{
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> slist=criteria.list();
		for (Student s : slist) {
			System.out.println(s);
		}
		
		session.close();
		sessionFactory.close();
	}
}
