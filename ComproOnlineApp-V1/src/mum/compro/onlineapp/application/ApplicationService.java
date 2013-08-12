package mum.compro.onlineapp.application;

import java.text.ParseException;
import java.util.List;

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
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public List<Application> getSubmittedApplications() {
		List<Application> applications = applicationDao.getSubmittedApplications();
		return applications;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public List<Application> getUnSubmittedApplications() {
		List<Application> applications = applicationDao.getUnSubmittedApplications();
		return applications;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public Application getApplication(long id){
		return applicationDao.getApplication(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void setApplicationDisposition(long id, String disposition){
		applicationDao.setApplicationDisposition(id, disposition);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void setApplicationUnsubmitted(long id, String status){
		applicationDao.setApplicationUnsubmitted(id, status);
	}	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Application searchApplicant(long id){
		return applicationDao.getApplication(id);
	}
}
