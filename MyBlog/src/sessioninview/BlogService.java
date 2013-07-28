package sessioninview;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BlogService {
	private PostDAO postdao;
	private UserDAO userdao;
	private CommentDAO commentdao;

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	public void setPostdao(PostDAO postdao) {
		this.postdao = postdao;
	}
	
	public void setCommentdao(CommentDAO commentdao) {
		this.commentdao = commentdao;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public User getUser(long userid) {
		User user = userdao.load(userid);
		Hibernate.initialize(user.getFirstName());
		return user;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public List<Post> getPosts() {
		List<Post> posts = postdao.getPosts();
		return posts;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public List<Post> getPostsForIndex() {
		List<Post> posts = postdao.getPostsForIndex();
		return posts;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void addNewUser(User user){
		userdao.create(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void addNewPost(Post post){
		postdao.create(post);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public Post getPost(long id) {
		return postdao.get(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updatePost(Post post) {
		postdao.update(post);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deletePost(long id) {
		postdao.delete(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = true)
	public List<Comment> getComments() {
		List<Comment> comments = commentdao.getComments();
		return comments;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void addNewComment(Comment comment){
		commentdao.create(comment);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteComment(long id) {
		commentdao.delete(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int checkUser(String username, String password) {
		if(userdao.getUser(username, password) > 0)
			return 1;
		else
			return 0;
	}
	
}
