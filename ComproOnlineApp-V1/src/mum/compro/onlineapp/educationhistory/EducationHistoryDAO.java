package mum.compro.onlineapp.educationhistory;

import java.util.List;

import mum.compro.onlineapp.EnglishProficiency;
import mum.compro.onlineapp.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class EducationHistoryDAO {
	private SessionFactory sf;
	public void init() {
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();

//		User user = new User("Lincoln", "Datta", "lincolnbd_cuet@yahoo.com", "1", "123456");
/*		Post post1 = new Post("Test title1", "Test content1", "publish",
				"05/19/2013");
		Post post2 = new Post("Test title2", "Test content2", "publish",
				"05/19/2013");
		Post post3 = new Post("Test title3", "Test content3", "publish",
				"05/19/2013");
		Comment comment1 = new Comment("05/19/2013", "Test comment for post1",
				1, 0);
		user.setPost(post1);
		user.setPost(post2);
		user.setPost(post3);
		user.setComment(comment1);
        post1.setComment(comment1);*/
		
//		session.persist(user);
//		tx.commit();
//		session.close();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}
	
	@Transactional
	public void create(EducationHistoryForm educationHistoryForm) {
		sf.getCurrentSession().persist(educationHistoryForm);
	}
	
	@Transactional
	public void saveOrUpdateEducationHistoryForm(EducationHistoryForm form) {
		form.setDisposition("save");
//		sf.getCurrentSession().persist(form);
		sf.getCurrentSession().saveOrUpdate(form);
		sf.getCurrentSession().flush();
	}
	@Transactional
	public void submitEducationHistoryForm(EducationHistoryForm form) {
		form.setDisposition("submit");
		sf.getCurrentSession().saveOrUpdate(form);
	}
	
	@Transactional
	public EducationHistoryForm getEducationHistoryFormById(long id) {
		return (EducationHistoryForm) sf.getCurrentSession().get(EducationHistoryForm.class, id);
	}
	
	@Transactional
	public EducationHistoryForm getEducationHistoryFormByUser(User user) {
		Criteria criteria = sf.getCurrentSession().createCriteria(EducationHistoryForm.class);
		criteria.add(Restrictions.eq("user", user));
		List list = criteria.list();
		if(list.size() == 0){
			return new EducationHistoryForm();
		}else{
			return (EducationHistoryForm)list.get(0);
		}
	}
	
//	@Transactional
//	public int getUser(String email, String password) {
//		Query query = (Query) sf.getCurrentSession().createQuery("from User where email = :email and password = :password");
//        query.setParameter("email", email);
//        query.setParameter("password", password);
//		@SuppressWarnings("unchecked")
//		List<User> users = query.list();
//		return users.size();
//	}
}
