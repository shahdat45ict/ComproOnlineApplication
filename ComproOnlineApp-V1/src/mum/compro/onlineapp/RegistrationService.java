package mum.compro.onlineapp;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class RegistrationService {
	private UserDAO userdao;

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public User getUser(long userid) {
		User user = userdao.load(userid);
		Hibernate.initialize(user.getFirstName());
		return user;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void addNewUser(User user){
		userdao.create(user);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int checkUser(String email, String password) {
		if(userdao.getUser(email, password) > 0)
			return 1;
		else
			return 0;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User getUserbyEmail(String email) {
		return userdao.getUserbyEmail( email);
	}

	/*public String getEmmailfromDatabase(String email) {
		// TODO Auto-generated method stub
		return userdao.getEmailfromDatabase(email);
	}*/
	
}
