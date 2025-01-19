package com.nk;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	//One to One Mapping with address
	@OneToOne(mappedBy="person",cascade=CascadeType.ALL)
	private Address address;
	
	//One to Many mapping with phone
	@OneToMany(mappedBy = "person" ,cascade=CascadeType.ALL)
	private List<Phone> phones;
	
	//Many to Many mapping with project
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_project",joinColumns = @JoinColumn(name="person_id"),inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Project> projects;
	
	

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Person(int id, String name, Address address, List<Phone> phones, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phones = phones;
		this.projects = projects;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", phones=" + phones + ", projects="
				+ projects + "]";
	}
	
	
	
}
