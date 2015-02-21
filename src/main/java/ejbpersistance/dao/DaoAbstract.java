package ejbpersistance.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DaoAbstract<C,I extends Serializable> {

    private EntityManagerFactory emf;

    public EntityManagerFactory getEntityManagerFactory() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("ejb-jpa");
        return emf;
    }
    
    Class<C> entityClass;

    {
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<C> getAll() {
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<C> object = em.createQuery("SELECT obj FROM " + entityClass.getAnnotation(Entity.class).name() + " obj")
                .getResultList();
        em.flush();
        em.getTransaction().commit();
        em.close();
        return object;
    }

    public C get(I id) {
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        C object = em.find(entityClass, id);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return object;
    }

    public C save(C object) {
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return object;
    }

    public void delete(C object) {
        emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(object) ? object : em.merge(object));
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
