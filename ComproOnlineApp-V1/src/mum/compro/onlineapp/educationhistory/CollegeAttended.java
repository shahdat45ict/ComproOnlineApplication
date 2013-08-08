package mum.compro.onlineapp.educationhistory;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CollegeAttended {
	@Id
	@GeneratedValue
	private long collegeAttendId;
	private String instituteName;
	private String location;
	private String dataFrom;
	private String degreeGranted;
	private String subjectArea;
	private String gpa;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "educationHistoryId", nullable = false)
	private EducationHistoryForm educationHistoryForm;


	public long getCollegeAttendId() {
		return collegeAttendId;
	}

	public void setCollegeAttendId(long collegeAttendId) {
		this.collegeAttendId = collegeAttendId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getDegreeGranted() {
		return degreeGranted;
	}

	public void setDegreeGranted(String degreeGranted) {
		this.degreeGranted = degreeGranted;
	}

	public String getSubjectArea() {
		return subjectArea;
	}

	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}


	
	public EducationHistoryForm getEducationHistoryForm() {
		return educationHistoryForm;
	}

	public void setEducationHistoryForm(EducationHistoryForm educationHistoryForm) {
		this.educationHistoryForm = educationHistoryForm;
	}
	
	
	
}
