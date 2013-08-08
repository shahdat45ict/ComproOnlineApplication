package mum.compro.onlineapp.educationhistory;

import mum.compro.onlineapp.User;
import mum.compro.onlineapp.UserDAO;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class EducationHistoryService {
	private EducationHistoryDAO educationHistoryDAO;

	
	public EducationHistoryDAO getEducationHistoryDAO() {
		return educationHistoryDAO;
	}

	public void setEducationHistoryDAO(EducationHistoryDAO educationHistoryDAO) {
		this.educationHistoryDAO = educationHistoryDAO;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public EducationHistoryForm getEducationHistoryFormById(long formId) {
		EducationHistoryForm form = educationHistoryDAO.getEducationHistoryFormById(formId);
		return form;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void saveOrUpdateEducationHistoryForm(EducationHistoryForm form) {
		educationHistoryDAO.saveOrUpdateEducationHistoryForm(form);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void submitEducationHistoryForm(EducationHistoryForm form) {
		educationHistoryDAO.submitEducationHistoryForm(form);
	}

//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	public int checkUser(String email, String password) {
//		if(userdao.getUser(email, password) > 0)
//			return 1;
//		else
//			return 0;
//	}
	
}
