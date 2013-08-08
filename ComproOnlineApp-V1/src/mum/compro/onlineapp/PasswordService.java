package mum.compro.onlineapp;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class PasswordService {
private UserDAO userdao;
	
	public UserDAO getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDAO userdao){
		this.userdao=userdao;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=true)
	public User getUser(long userid){
		User user=userdao.load(userid);
		Hibernate.initialize(user.getFirstName());
		return user;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public String checkPassword(String oldPassword, String email) {
		return userdao.checkPassword( oldPassword, email);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User getUserbyEmail(String email){
		return userdao.getUserbyEmail(email);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updatePassword(String newpassword, User userdb){
		userdao.updatePassword(newpassword, userdb);
	}
	

}
