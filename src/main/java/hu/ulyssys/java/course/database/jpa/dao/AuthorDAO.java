package hu.ulyssys.java.course.database.jpa.dao;

import hu.ulyssys.java.course.database.jpa.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDAO {

    private static final String PERSISNTENCE_UNIT = "TestPersistence";

    private EntityManager createEntityManager(){
        return Persistence.createEntityManagerFactory(PERSISNTENCE_UNIT).createEntityManager();
    }
    public void save(Author author){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Author author){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Author> findAll(){
        TypedQuery<Author> typedQuery = createEntityManager().createQuery("select n from Author n", Author.class);
        return typedQuery.getResultList();
    }

    public List<Author> findByUserName(String userName) {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n where n.userName=:name", Author.class);
        query.setParameter("name", userName);
        return query.getResultList();
    }
}
