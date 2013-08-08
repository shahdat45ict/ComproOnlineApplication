package mum.compro.onlineapp;

import java.sql.ResultSet;
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
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public void create(User user) {
		sf.getCurrentSession().persist(user);
	}

	@Transactional
	public User load(long userid) {
		return (User) sf.getCurrentSession().get(User.class, userid);
	}

	@Transactional
	public int getUser(String email, String password) {
		Query query = (Query) sf.getCurrentSession().createQuery(
				"from User where email = :email and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
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
	
	
	/*@Transactional
	public String getEmailfromDatabase(String email){
	User	user= (User) (sf.getCurrentSession()
				.createQuery("from User where email = :email")
				.setParameter("email", email).uniqueResult());
	      return user.getEmail();
		
	}*/
}
