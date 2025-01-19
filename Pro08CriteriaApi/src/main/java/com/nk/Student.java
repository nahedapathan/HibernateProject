package com.nk;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	private int id;
	private String name;
	private int marks;
	private String specialSub;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, int marks, String specialSub) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.specialSub = specialSub;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getSpecialSub() {
		return specialSub;
	}

	public void setSpecialSub(String specialSub) {
		this.specialSub = specialSub;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", specialSub=" + specialSub + "]";
	}
	
	
}
