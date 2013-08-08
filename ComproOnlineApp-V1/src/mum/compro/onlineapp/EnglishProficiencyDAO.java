package mum.compro.onlineapp;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class EnglishProficiencyDAO {
	private SessionFactory sf;
	public void init() {		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public void create(EnglishProficiency englishProficiency) {
		sf.getCurrentSession().persist(englishProficiency);
	}
	
	@Transactional
	public EnglishProficiency load(long id) {
		return (EnglishProficiency) sf.getCurrentSession().get(EnglishProficiency.class, id);
	}
	
	public void update(EnglishProficiency englishProficiency) {
		sf.getCurrentSession().saveOrUpdate(englishProficiency);
	}
	
}
