package mum.compro.onlineapp.application;

import java.text.ParseException;

import mum.compro.onlineapp.PersonalInfo;
import mum.compro.onlineapp.User;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class ApplicationService {
	private ApplicationDAO applicationDao;

	public ApplicationDAO getApplicationDao() {
		return applicationDao;
	}

	public void setApplicationDao(ApplicationDAO applicationDao) {
		this.applicationDao = applicationDao;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void submitApplication(User user) {		
		applicationDao.submitApplication(user);
	}
}
