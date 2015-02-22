package ejbpersistance.dao;


import java.util.List;

import javax.persistence.EntityManager;

import ejbpersistance.entities.Comment;
import ejbpersistance.entities.User;

/**
 * Created by Maxime on 12/30/2014.
 */
public class CommentDao extends DaoAbstract<Comment, Integer>{

	public List<Comment> findAllByArticle(Integer id) {
		ArticleDao adao = new ArticleDao();
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        List<Comment> us = null;
        us = em.createQuery("SELECT c FROM comment c WHERE c.article = :article")
        	    .setParameter("article", adao.get((Integer)id))
        	    .getResultList();
        if(us.size() > 0)
            return us;
        else
        	return null;
	}


}
