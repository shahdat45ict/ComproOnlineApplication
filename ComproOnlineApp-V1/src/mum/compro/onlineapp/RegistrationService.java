package mum.compro.onlineapp;

import mum.compro.mail.util.MailUtil;
import mum.compro.onlineapp.application.ApplicationDAO;
import mum.compro.onlineapp.educationhistory.EducationHistoryDAO;
import mum.compro.onlineapp.educationhistory.EducationHistoryForm;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class RegistrationService {
	private UserDAO userdao;
	private ApplicationDAO applicationdao;
	private PersonalInfoDAO personalInfoDao;
	private EnglishProficiencyDAO englishProficiencyDao;
	private EducationHistoryDAO educationHistoryDao;


	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	
	public void setApplicationdao(ApplicationDAO applicationdao) {
		this.applicationdao = applicationdao;
	}	
	
	public void setPersonalInfoDao(PersonalInfoDAO personalInfoDao) {
		this.personalInfoDao = personalInfoDao;
	}
	
	public void setEnglishProficiencyDao(EnglishProficiencyDAO englishProficiencyDao) {
		this.englishProficiencyDao = englishProficiencyDao;
	}
	
	public void setEducationHistoryDao(EducationHistoryDAO educationHistoryDao) {
		this.educationHistoryDao = educationHistoryDao;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public User getUser(long userid) {
		User user = userdao.load(userid);
		Hibernate.initialize(user.getFirstName());
		return user;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public Long addNewUser(User user){
		//MailUtil.sendEmailTo(desAddress, subject, content);
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfoDao.create(personalInfo);
		
		EnglishProficiency englishProficiency = new EnglishProficiency();
		englishProficiencyDao.create(englishProficiency);
		
		EducationHistoryForm educationHistoryForm = new EducationHistoryForm();	
		educationHistoryDao.create(educationHistoryForm);
		
		applicationdao.create(user, personalInfo, englishProficiency, educationHistoryForm);
		
		return userdao.create(user);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void activated(long userId){
		//MailUtil.sendEmailTo(desAddress, subject, content);
		userdao.activated(userId);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int checkUser(String email, String password) {
		if(userdao.getUser(email, password) > 0)
			return 1;
		else
			return 0;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User getUserbyEmail(String email) {
		return userdao.getUserbyEmail( email);
	}

	/*public String getEmmailfromDatabase(String email) {
		// TODO Auto-generated method stub
		return userdao.getEmailfromDatabase(email);
	}*/
	
}
