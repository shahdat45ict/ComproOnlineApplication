package sessioninview;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class CommentDAO {
	private SessionFactory sf;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public void create(Comment comment) {
		sf.getCurrentSession().persist(comment);
	}

	public Comment get(long id) {
		return (Comment) sf.getCurrentSession().get(Comment.class, id);
	}

	public void update(Comment comment) {
		sf.getCurrentSession().saveOrUpdate(comment);
	}

	public void delete(long id) {
		Comment comment = (Comment) sf.getCurrentSession().load(Comment.class, id);
		if (null != comment) {
			this.sf.getCurrentSession().delete(comment);
		}
	}

	public List<Comment> getComments() {
		Query query = sf.getCurrentSession().createQuery(
				"from Comment");
/*		Query query = sf.getCurrentSession().createQuery(
				"from Post where status = :status");
		query.setParameter("status", "publish");*/
		@SuppressWarnings("unchecked")
		List<Comment> comments = query.list();
		return comments;
	}
}
