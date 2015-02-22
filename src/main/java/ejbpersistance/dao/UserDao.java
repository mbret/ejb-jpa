package ejbpersistance.dao;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.*;

import ejbpersistance.entities.User;

/**
 * Created by Maxime on 12/30/2014.
 */
@NamedQueries({
	@NamedQuery(
	    name="findOneUser",
	    query="SELECT c FROM users c WHERE c.email LIKE :mail AND c.password LIKE :password"
	),
	@NamedQuery(
	    name="emailExist",
	    query="SELECT c FROM users c WHERE c.email LIKE :mail"
	)
})

public class UserDao extends DaoAbstract<User, Integer>{

	public User findOne(String email, String password) throws Exception{
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u = (User) em.createNamedQuery("findOneUser")
        	    .setParameter("mail", email)
        	    .setParameter("password", password)
        	    .getSingleResult();
        em.flush();
        em.getTransaction().commit();
        em.close();
        return u;
    }

	public boolean emailExist(String email) {
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean exist = true;
        try{
            em.createNamedQuery("emailExist")
                    .setParameter("mail", email)
                    .getSingleResult();
        }
        catch(NoResultException e){
            exist = false;
        }
        finally {
            em.flush();
            em.getTransaction().commit();
            em.close();
            return exist;
        }
	}
}
