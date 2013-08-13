package mum.compro.onlineapp.application;

import java.text.ParseException;
import java.util.List;

import mum.compro.mail.util.MailUtil;
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
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void sendStatusEmailToApplicant(long id){	
		String email = this.getApplication(id).getPersonalInfo().getEmail();
		String emailSubject = "Application status of MUM";
		String emailContent = "Your Submitted application to MUM for MS in Computer Science has been changed to Un Submitted status. \n\n";
		emailContent += "Thank you. \n";
		emailContent += "Application Service \n MUM, Fairfield, Iowa, USA.";
		MailUtil.sendEmailTo(email, emailSubject, emailContent);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void sendDispositionEmailToApplicant(long id, String disposition){	
		String email = this.getApplication(id).getPersonalInfo().getEmail();
		String emailSubject = "Application result of MUM";
		String emailContent = "Your Submitted application to MUM for MS in Computer Science has been reviewed by our admission team. \n\n";
		if(disposition.equals("pass"))
			emailContent += "Congratulation, you are qualied in the primary review. \n\n";
		if(disposition.equals("fail"))
			emailContent += "You are not qualified in the primary review. \n\n";
		emailContent += "Thank you. \n";
		emailContent += "Application Service \n MUM, Fairfield, Iowa, USA.";
		MailUtil.sendEmailTo(email, emailSubject, emailContent);
	}
}
