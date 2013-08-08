package mum.compro.onlineapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.compro.countrylist.CountryList;

public class PersonalInfoService {
	private PersonalInfoDAO personalInfoDao;
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
	private static Date dob;

	public void setPersonalInfoDao(PersonalInfoDAO personalInfoDao) {
		this.personalInfoDao = personalInfoDao;
	}

	public List<String> getAllCountryList() {
		return CountryList.getAllCountry();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addNewPersonalInfo(PersonalInfo personalInfo, String month, String day, String year) {
		String dateOfBirth = month + "/" + day + "/" + year;
		try {
			dob =  df.parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personalInfo.setDateOfBirth(dob);
		personalInfoDao.create(personalInfo);
	}
	
	public PersonalInfo getPersonalInfo(long id){
		return personalInfoDao.getPersonalInfo(id);

	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updatePersonalInfo(PersonalInfo personalInfo, String month, String day, String year) {
		String dateOfBirth = month + "/" + day + "/" + year;
		try {
			dob =  df.parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personalInfo.setDateOfBirth(dob);
		personalInfoDao.updatePersonalInfo(personalInfo);
	}
}
