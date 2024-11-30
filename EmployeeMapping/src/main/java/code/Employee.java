package code;

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
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToOne(mappedBy ="employee", cascade=CascadeType.ALL)
	private Department department;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private List<Phone> phone;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="employee_project",joinColumns = @JoinColumn(name="employee_id") ,inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Project> project;

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

	public Department getDepartment() {
		return department;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	
	
	
	
}
