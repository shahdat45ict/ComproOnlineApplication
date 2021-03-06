package mum.compro.onlineapp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mum.compro.onlineapp.application.Application;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date registered;
	private String status="unactivated";
	private UserType userType;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Application application;
	

	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);
	
	public User() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User(String firstName, String lastName, String email,
			String status, String password, UserType userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.password = password;
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = md5(password);
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered() {
		try {
			Date dt = new Date();
			String registrationDate =  dt.getMonth() + "/" + dt.getDay() + "/" + dt.getYear();
			this.registered = df.parse(registrationDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
    public static String md5(String input) {      
        String md5 = null;         
        if(null == input) return null;         
        try {             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16); 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
	
}
