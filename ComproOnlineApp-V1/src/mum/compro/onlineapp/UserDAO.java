package mum.compro.onlineapp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class UserDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	/*
	 * public void setSf(SessionFactory sf) { this.sf = sf; }
	 */

	public void init() {
		Session session = sf.openSession();
		 Transaction tx = session.beginTransaction();
		  
		  User admin=new  User("System", "Admin", "systemadmin@mum.com", "activated", User.md5("123456"), UserType.Administrator); 
		  User adst1=new  User("Admission", "Staff", "admissionstaff1@mum.com", "activated", User.md5("123456"), UserType.AdmissionStaff);
		  User adst2=new  User("Admission", "Staff", "admissionstaff2@mum.com", "activated", User.md5("123456"), UserType.AdmissionStaff);
		  User adst3=new  User("Admission", "Staff", "admissionstaff3@mum.com", "activated", User.md5("123456"), UserType.AdmissionStaff);
		  session.persist(admin);
		  session.persist(adst1);
		  session.persist(adst2);
		  session.persist(adst3);
		  tx.commit();
		  session.close();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public Long create(User user) {
		return (Long)sf.getCurrentSession().save(user);
	}

	@Transactional
	public User load(long userid) {
		return (User) sf.getCurrentSession().get(User.class, userid);
	}

	@Transactional
	public int getUser(String email, String password) {
		Query query = (Query) sf.getCurrentSession().createQuery(
				"from User where email = :email and password = :password and status = :status");
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("status", "activated");
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		return users.size();
	}

	@Transactional
	public User getUserDetails(String email) {
		Query query = (Query) sf.getCurrentSession().createQuery(
				"from User where email = :email");
		query.setParameter("email", email);
		// query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		User user = (User) query.uniqueResult();
		return user;
	}
	
    @Transactional
	public void updatePassword(String newpassword, User user) {
	user.setPassword(newpassword);
	sf.getCurrentSession().saveOrUpdate(user);
	 
	}

	@Transactional
	public String checkPassword(String oldPassword, String email) {
		User user = getUserbyEmail(email);
		if (oldPassword.equals(user.getPassword()))
			return "true";
		else 
			return "false";
	}
	@Transactional
	public User getUserbyEmail(String email) {
		return (User) sf.getCurrentSession()
				.createQuery("from User where email = :email")
				.setParameter("email", email).uniqueResult();
	}
	@Transactional
	public void activated(long userid) {
		
		Session currentSession = sf.getCurrentSession();
		User user = (User)currentSession.get(User.class, userid);
		user.setUserType(UserType.Applicant);
		user.setStatus("activated");
		currentSession.saveOrUpdate(user);
	}
	
	
	/*@Transactional
	public String getEmailfromDatabase(String email){
	User	user= (User) (sf.getCurrentSession()
				.createQuery("from User where email = :email")
				.setParameter("email", email).uniqueResult());
	      return user.getEmail();
		
	}*/
}
