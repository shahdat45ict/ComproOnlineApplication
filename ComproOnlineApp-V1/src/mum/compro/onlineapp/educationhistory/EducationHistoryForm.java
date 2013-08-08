package mum.compro.onlineapp.educationhistory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import mum.compro.onlineapp.User;

@Entity
public class EducationHistoryForm {
	@Id
	@GeneratedValue
	private long educationHistoryId;
	private String whetherHighLevelEducation;
	private String highestDegreeYear;
	private String highestDegreeField;
	private String highestDegree;
	private String highestDegreeCountry;
	private String gradingScaleUser;
	private String highestDegreeGPA;
	private String totalYearOfSecondaryEdu;
	private String totalMonthOfSecondaryEdu;
	private String disposition;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private User user;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "collegeattended", joinColumns = { @JoinColumn(name = "collegeAttendId") })
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "collegeattended", joinColumns = { @JoinColumn(name = "collegeAttendId") }, inverseJoinColumns = { @JoinColumn(name = "educationHistoryId") })
	private List<CollegeAttended> collegeList = new ArrayList<CollegeAttended>();
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getEducationHistoryId() {
		return educationHistoryId;
	}
	public void setEducationHistoryId(long educationHistoryId) {
		this.educationHistoryId = educationHistoryId;
	}
	public String getWhetherHighLevelEducation() {
		return whetherHighLevelEducation;
	}
	public void setWhetherHighLevelEducation(String whetherHighLevelEducation) {
		this.whetherHighLevelEducation = whetherHighLevelEducation;
	}
	public String getHighestDegreeYear() {
		return highestDegreeYear;
	}
	public void setHighestDegreeYear(String highestDegreeYear) {
		this.highestDegreeYear = highestDegreeYear;
	}
	public String getHighestDegreeField() {
		return highestDegreeField;
	}
	public void setHighestDegreeField(String highestDegreeField) {
		this.highestDegreeField = highestDegreeField;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public String getHighestDegreeCountry() {
		return highestDegreeCountry;
	}
	public void setHighestDegreeCountry(String highestDegreeCountry) {
		this.highestDegreeCountry = highestDegreeCountry;
	}
	public String getGradingScaleUser() {
		return gradingScaleUser;
	}
	public void setGradingScaleUser(String gradingScaleUser) {
		this.gradingScaleUser = gradingScaleUser;
	}
	public String getHighestDegreeGPA() {
		return highestDegreeGPA;
	}
	public void setHighestDegreeGPA(String highestDegreeGPA) {
		this.highestDegreeGPA = highestDegreeGPA;
	}
	public String getTotalYearOfSecondaryEdu() {
		return totalYearOfSecondaryEdu;
	}
	public void setTotalYearOfSecondaryEdu(String totalYearOfSecondaryEdu) {
		this.totalYearOfSecondaryEdu = totalYearOfSecondaryEdu;
	}
	public String getTotalMonthOfSecondaryEdu() {
		return totalMonthOfSecondaryEdu;
	}
	public void setTotalMonthOfSecondaryEdu(String totalMonthOfSecondaryEdu) {
		this.totalMonthOfSecondaryEdu = totalMonthOfSecondaryEdu;
	}
//	@OneToMany(mappedBy="educationHistoryForm")
	public List<CollegeAttended> getCollegeList() {
		return collegeList;
	}
	public void setCollegeList(List<CollegeAttended> collegeList) {
		this.collegeList = collegeList;
	}
	public String getDisposition() {
		return disposition;
	}
	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
	
}
