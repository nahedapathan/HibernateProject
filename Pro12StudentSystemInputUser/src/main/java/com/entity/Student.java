package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentid;
    private String name;
    private String email;
    private int age;
    private String grade;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String email, int age, String grade) {
		super();
		
		this.name = name;
		this.email = email;
		this.age = age;
		this.grade = grade;
	}
	
	
	
	public Student(int studentid, String name, String email, int age, String grade) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.email = email;
		this.age = age;
		this.grade = grade;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", name=" + name + ", email=" + email + ", age=" + age + ", grade="
				+ grade + "]";
	}
    
    
    
    
}
