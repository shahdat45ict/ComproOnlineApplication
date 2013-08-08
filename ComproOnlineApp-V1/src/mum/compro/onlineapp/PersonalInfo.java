package mum.compro.onlineapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersonalInfo {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String middleName;
	private String surName;
	private String sex;
	private String maritalStatus;
	private String countryOfCitizenship;
	private String countryOfBirth;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String email;
	private String skypeId;
	private String phone;
	private String cityLiveIn;
	private String countryLiveIn;
	
	
		
	public PersonalInfo() {
	}

	public PersonalInfo(long id, String firstName, String middleName,
			String surName, String sex, String maritalStatus,
			String countryOfCitizenship, String countryOfBirth,
			Date dateOfBirth, String email, String skypeId, String phone,
			String cityLiveIn, String countryLiveIn) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surName = surName;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.countryOfCitizenship = countryOfCitizenship;
		this.countryOfBirth = countryOfBirth;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.skypeId = skypeId;
		this.phone = phone;
		this.cityLiveIn = cityLiveIn;
		this.countryLiveIn = countryLiveIn;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		 this.id = id;
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCountryOfCitizenship() {
		return countryOfCitizenship;
	}

	public void setCountryOfCitizenship(String countryOfCitizenship) {
		this.countryOfCitizenship = countryOfCitizenship;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCityLiveIn() {
		return cityLiveIn;
	}

	public void setCityLiveIn(String cityLiveIn) {
		this.cityLiveIn = cityLiveIn;
	}

	public String getCountryLiveIn() {
		return countryLiveIn;
	}

	public void setCountryLiveIn(String countryLiveIn) {
		this.countryLiveIn = countryLiveIn;
	}

}
