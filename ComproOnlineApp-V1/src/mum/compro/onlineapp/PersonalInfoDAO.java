package mum.compro.onlineapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class PersonalInfoDAO {
	
	private SessionFactory sf;
	
	public void init() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}
	
	@Transactional
	public void create(PersonalInfo personalInfo) {
		sf.getCurrentSession().persist(personalInfo);
	}
	
	@Transactional
	public PersonalInfo getPersonalInfo(long id){
		return (PersonalInfo) sf.getCurrentSession().get(PersonalInfo.class, id);
	}
	
	public void updatePersonalInfo(PersonalInfo personalInfo) {
		sf.getCurrentSession().saveOrUpdate(personalInfo);
	}
}
