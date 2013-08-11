package mum.compro.onlineapp.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;  
import org.hibernate.annotations.Parameter; 

import mum.compro.onlineapp.EnglishProficiency;
import mum.compro.onlineapp.PersonalInfo;
import mum.compro.onlineapp.User;

@Entity
public class Application {
	@Id
	@GeneratedValue(generator="myGenerator")
    @GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter(name="property", value="user")) 
	private long id;
	private String disposition;
	private String status;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@OneToOne
	private PersonalInfo personalInfo;
	
	@OneToOne
	private EnglishProficiency englishProficiency;
	
/*	@OneToOne
	@PrimaryKeyJoinColumn
	private EducationHistoryForm educationHistoryForm;*/
	
	public Application() {
	}
	
	public Application(String disposition, String status, User user, PersonalInfo personalInfo, EnglishProficiency englishProficiency) {
		this.disposition = disposition;
		this.status = status;
		this.user = user;
		this.personalInfo = personalInfo;
		this.englishProficiency = englishProficiency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public EnglishProficiency getEnglishProficiency() {
		return englishProficiency;
	}

	public void setEnglishProficiency(EnglishProficiency englishProficiency) {
		this.englishProficiency = englishProficiency;
	}
}
