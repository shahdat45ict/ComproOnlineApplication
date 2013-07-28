package sessioninview;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class PostDAO {
	private SessionFactory sf;

	public void init() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Post post1 = new Post("Hello world!", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "publish",
				"05/19/2013");
		Post post2 = new Post("What is Lorem Ipsum?", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "publish",
				"05/19/2013");
		Post post3 = new Post("What is Lorem Ipsum?", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "publish",
				"05/19/2013");

		session.persist(post1);
		session.persist(post2);
		session.persist(post3);
		tx.commit();
		session.close();

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public void create(Post post) {
		sf.getCurrentSession().persist(post);
	}

	public Post get(long id) {
		return (Post) sf.getCurrentSession().get(Post.class, id);
	}

	public void update(Post post) {
		sf.getCurrentSession().saveOrUpdate(post);
	}

	public void delete(long id) {
		Post post = (Post) sf.getCurrentSession().load(Post.class, id);
		if (null != post) {
			this.sf.getCurrentSession().delete(post);
		}
	}

	public List<Post> getPosts() {
		Query query = sf.getCurrentSession().createQuery(
				"from Post");
/*		Query query = sf.getCurrentSession().createQuery(
				"from Post where status = :status");
		query.setParameter("status", "publish");*/
		@SuppressWarnings("unchecked")
		List<Post> posts = query.list();
		return posts;
	}
	
	public List<Post> getPostsForIndex() {
		Query query = sf.getCurrentSession().createQuery(
				"from Post where status = :status");
		query.setParameter("status", "publish");
		@SuppressWarnings("unchecked")
		List<Post> posts = query.list();
		return posts;
	}
	
}
