package com.service;

import com.dao.StudentDAO;
import com.entity.Student;

public class StudentService {

	StudentDAO studentdao=new StudentDAO();
	
	public void createStudent( String name, String email, int age, String grade)
	{
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setAge(age);
		student.setGrade(grade);
		studentdao.addStudent(student);
	}
	
	public void getStudentById(int id)
	{
		studentdao.getStudentByID(id);
	}
	
	public void getStudentAll() 
	{
		studentdao.getAllStudent();
	}
	
	// Method to update a student's details
    public void updateStudent(int id, String name, String email, int age, String grade) {
        Student updatedData = new Student();
        updatedData.setName(name);
        updatedData.setEmail(email);
        updatedData.setAge(age);
        updatedData.setGrade(grade);

        studentdao.updateStudent(id, updatedData);
    }

    // Method to delete a student by ID
    public void deleteStudent(int id) {
        studentdao.deleteStudent(id);
    }
	
}
