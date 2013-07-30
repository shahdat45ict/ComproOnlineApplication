package sessioninview;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String applicantId;

	@Temporal(TemporalType.DATE)
	private Date registered;
	private String status;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_post", joinColumns = { @JoinColumn(name = "User_id") }, inverseJoinColumns = { @JoinColumn(name = "Post_id") })
	private List<Post> posts = new ArrayList<Post>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_comment", joinColumns = { @JoinColumn(name = "User_id") }, inverseJoinColumns = { @JoinColumn(name = "Comment_Id") })
	private List<Comment> comments = new ArrayList<Comment>();

	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);
	
	public User() {
	}
	
	public User(String firstName, String lastName, String email, String registered,
			String status, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.setRegistered(registered);
		this.status = status;
		this.password = password;
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
		this.password = password;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		try {
			this.registered = df.parse(registered);
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPost(Post post) {
		this.posts.add(post);
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public String getFullName(){
		return this.getFirstName() + this.getLastName();
	}
}
