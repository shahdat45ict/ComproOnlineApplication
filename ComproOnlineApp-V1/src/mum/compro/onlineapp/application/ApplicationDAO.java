package mum.compro.onlineapp.application;

import java.util.List;

import mum.compro.onlineapp.EnglishProficiency;
import mum.compro.onlineapp.PersonalInfo;
import mum.compro.onlineapp.User;
import mum.compro.onlineapp.educationhistory.EducationHistoryForm;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
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
	
	public Long create(User user, PersonalInfo personalInfo, EnglishProficiency englishProficiency, EducationHistoryForm educationHistoryForm) {
		Application application = new Application("undetermined", "un-submitted", user, personalInfo, englishProficiency, educationHistoryForm);
		return (Long)sf.getCurrentSession().save(application);
	}
	
	public void submitApplication(User user){
		user.getApplication().setStatus("submitted");
		sf.getCurrentSession().saveOrUpdate(user.getApplication());
	}
	
	
	public List<Application> getSubmittedApplications() {
		//Query query = (Query) sf.getCurrentSession().createQuery(
		//		"from Application");
		Query query = (Query) sf.getCurrentSession().createQuery("from Application where status = :status");
		query.setParameter("status", "submitted");
		@SuppressWarnings("unchecked")
		List<Application> applications = query.list();
		return applications;
	}
	
	public List<Application> getUnSubmittedApplications() {
		//Query query = (Query) sf.getCurrentSession().createQuery(
		//		"from Application");
		Query query = (Query) sf.getCurrentSession().createQuery("from Application where status = :status");
		query.setParameter("status", "un-submitted");
		@SuppressWarnings("unchecked")
		List<Application> applications = query.list();
		return applications;
	}
	
	public Application getApplication(long id) {
		return (Application) sf.getCurrentSession().get(Application.class, id);
	}
	
	public void setApplicationDisposition(long id, String disposition){
		Query query = (Query) sf.getCurrentSession().createQuery("update Application set disposition = :disposition where id = :id");
		query.setParameter("disposition", disposition);
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	public void setApplicationUnsubmitted(long id, String status){
		Query query = (Query) sf.getCurrentSession().createQuery("update Application set status = :status where id = :id");
		query.setParameter("status", status);
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
}
