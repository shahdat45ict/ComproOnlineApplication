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

import org.springframework.format.datetime.joda.DateTimeParser;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private long id;
	private long author;
	private String title = null;
	private String content;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "post_comment", joinColumns = { @JoinColumn(name = "Post_id") }, inverseJoinColumns = { @JoinColumn(name = "Comment_id") })
	private List<Comment> comments = new ArrayList<Comment>();

	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);

	public Post(String title, String content, String status, String modified) {
		this.title = title;
		this.content = content;
		this.status = status;
		this.setModified(modified);
	}

	public Post() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAuthor() {
		return author;
	}

	public void setAuthor(long author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(String modified) {
		try {
			this.modified = df.parse(modified);
		    //java.util.Date today = new java.util.Date();
		    //this.modified = today;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComment(Comment comment) {
		this.comments.add(comment);
	}

}
