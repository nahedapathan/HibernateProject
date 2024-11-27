package code1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fid;
	
	@Column(name="fname")
	private String fname;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="subject")
	private FacultySubject facultysubject;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public FacultySubject getFacultysubject() {
		return facultysubject;
	}

	public void setFacultysubject(FacultySubject facultysubject) {
		this.facultysubject = facultysubject;
	}

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", facultysubject=" + facultysubject + "]";
	}
	
	
	
}
