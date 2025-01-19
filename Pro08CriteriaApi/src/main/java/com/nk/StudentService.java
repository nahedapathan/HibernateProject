package com.nk;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class StudentService {

	//Add Student
	public void addStudent(Session session,Student student)
	{
		Transaction tx=session.beginTransaction();
		session.save(student);
		tx.commit();
		System.out.println("Student added: "+student);
		
	}
	
	//UpdateStudent
	public void updateStudent(Session session ,int id,String name,int marks,String specialSub)
	{
		Transaction tx=session.beginTransaction();
		Student student=session.get(Student.class, id);
		if(student!=null)
		{
			student.setName(name);
			student.setMarks(marks);
			student.setSpecialSub(specialSub);
			session.update(student);
			tx.commit();
			System.out.println("System Updated: "+student);
		}
		else
		{
			System.out.println("Student not found with ID:"+id);
		}
	}
	
	//DeleteStudent
	public void deleteStudent(Session session,int id)
	{
		Transaction tx=session.beginTransaction();
		Student student=session.get(Student.class, id);
		if(student !=null)
		{
			session.delete(student);
			tx.commit();
			System.out.println("Student Deleted: "+student);
		}
		else
		{
			System.out.println("Student not found with Id: "+id);
		}
	}
	
	
	//Display All Student Using Criteri api
	public void displayAllStudent(Session session)
	{
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> students=criteria.list();
		students.forEach(System.out::println);
	}
	
	
	//Display StudentsBased on Criteria marks>greaterThan
	public void displayStudentsWithMarksGreaterThan(Session session,int marks)
	{
		Criteria criteria=session.createCriteria(Student.class);
		criteria.add(Restrictions.gt("marks", marks));
		List<Student> students=criteria.list();
		students.forEach(System.out::println);
		
				
	}
	
	//Display Student With Maximum Marks
	public void displayStudentWithMarks(Session session)
	{
		Criteria criteria=session.createCriteria(Student.class);
		criteria.setProjection(Projections.max("marks"));
		Integer maxMarks=(Integer) criteria.uniqueResult();
		
		Criteria subCriteria=session.createCriteria(Student.class);
		subCriteria.add(Restrictions.eq("marks", maxMarks));
		List<Student> students=subCriteria.list();
		students.forEach(System.out::println);
	}
	
}
