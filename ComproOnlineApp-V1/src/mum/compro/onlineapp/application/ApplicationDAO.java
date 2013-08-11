package mum.compro.onlineapp.application;

import mum.compro.onlineapp.EnglishProficiency;
import mum.compro.onlineapp.PersonalInfo;
import mum.compro.onlineapp.User;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class ApplicationDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	public void init() {
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}
	
	public Long create(User user, PersonalInfo personalInfo, EnglishProficiency englishProficiency) {
		Application application = new Application("un-submitted", "undetermined", user, personalInfo, englishProficiency);
		return (Long)sf.getCurrentSession().save(application);
	}
}
