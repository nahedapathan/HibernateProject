package com.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Student;

public class StudentService {

	// Create
	public void addStudent(SessionFactory sessionFactory, Student student) {
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();
	        session.save(student);
	        session.getTransaction().commit();
	       
	        System.out.println("Student data Added");
	    } catch (Exception e) {
	        System.err.println("Error adding student: " + e.getMessage());
	    }
	}

	// Update
	public void updateStudent(SessionFactory sessionFactory, Student student) {
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();
	        Student updateStudent = session.get(Student.class, student.getStudentid());
	        if (updateStudent != null) {
	            updateStudent.setName(student.getName());
	            updateStudent.setAge(student.getAge());
	            updateStudent.setEmail(student.getEmail());
	            updateStudent.setGrade(student.getGrade());
	            session.saveOrUpdate(updateStudent);
	           
	            System.out.println("Data Updated Successfully");
	        } else {
	            System.out.println("Student not found for Updation");
	        }
	        session.getTransaction().commit();
	        session.close();
	    } catch (Exception e) {
	        System.err.println("Error updating student: " + e.getMessage());
	    }
	}

	// Delete
	public void deleteStudent(SessionFactory sessionFactory, int studentId) {
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();
	        Student student = session.get(Student.class, studentId);
	        if (student != null) {
	            session.delete(student);
	            System.out.println("Student Deleted");
	        } else {
	            System.out.println("Student not found!");
	        }
	        session.getTransaction().commit();
	        
	    } catch (Exception e) {
	        System.err.println("Error deleting student: " + e.getMessage());
	    }
	}

	// Retrieve by ID
	public void getStudentByID(SessionFactory sessionFactory, int studentId) {
	    try (Session session = sessionFactory.openSession()) {
	        Student student = session.get(Student.class, studentId);
	        if (student != null) {
	            System.out.println(student);
	        } else {
	            System.out.println("Student not Found!");
	        }
	        
	    } catch (Exception e) {
	        System.err.println("Error retrieving student by ID: " + e.getMessage());
	    }
	}

	// Retrieve All
	public void getAllStudent(SessionFactory sessionFactory) {
	    try (Session session = sessionFactory.openSession()) {
	        Criteria criteria = session.createCriteria(Student.class);
	        List<Student> list = criteria.list();
	        for (Student s : list) {
	            System.out.println(s);
	        }
	      
	    } catch (Exception e) {
	        System.err.println("Error retrieving all students: " + e.getMessage());
	    }
	}

}


