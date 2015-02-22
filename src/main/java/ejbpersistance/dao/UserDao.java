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
	    query="SELECT c FROM user c WHERE c.email LIKE :mail AND c.password LIKE :password"
	),
	@NamedQuery(
	    name="emailExist",
	    query="SELECT c FROM user c WHERE c.email LIKE :mail"
	)
})

public class UserDao extends DaoAbstract<User, Integer>{

	public User findOne(String email, String password){
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        User u = null;
        List<User> us = null;
        us = em.createQuery("SELECT c FROM user c WHERE c.email LIKE :mail AND c.password LIKE :password")
        	    .setParameter("mail", email)
        	    .setParameter("password", password)
        	    .getResultList();
        if(us.size() > 0)
        	u = us.get(0);
        else
        	return null;
        return u;
    }

	public boolean emailExist(String email) {
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        boolean b = false;
        List<User> us = null;
        us = em.createQuery("SELECT c FROM user c WHERE c.email LIKE :mail")
                .setParameter("mail", email)
                .getResultList();
        if(us.size()==0)
        	return false;
        else
        	return true;
	}
}
