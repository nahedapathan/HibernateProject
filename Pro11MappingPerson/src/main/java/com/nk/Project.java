package com.nk;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table
public class Project {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Person> persons;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int id, String projectName, List<Person> persons) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.persons = persons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", persons=" + persons + "]";
	}
	
	
	
}
