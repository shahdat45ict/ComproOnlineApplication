package sessioninview;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	private String content;
	private String name;
	private String email;
	private String website;
	private int approval;
	private int parent;
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);
	
	public Comment(String date, String content, String name, String email, String website, int approval, int parent) {
		this.setDate(date);
		this.content = content;
		this.approval = approval;
		this.parent = parent;
		this.name = name;
		this.email = email;
		this.website = website;
	}

	public Comment() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
