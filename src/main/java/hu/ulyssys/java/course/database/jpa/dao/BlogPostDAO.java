package hu.ulyssys.java.course.database.jpa.dao;

import hu.ulyssys.java.course.database.jpa.entity.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogPostDAO {

    private static final String PERSISNTENCE_UNIT = "TestPersistence";

    private EntityManager createEntityManager(){
        return Persistence.createEntityManagerFactory(PERSISNTENCE_UNIT).createEntityManager();
    }
    public void save(BlogPost blogPost){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(BlogPost blogPost){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<BlogPost> findAll(){
        TypedQuery<BlogPost> typedQuery = createEntityManager().createQuery("select n from BlogPost n", BlogPost.class);
        return typedQuery.getResultList();
    }

    public List<BlogPost> findByTitle(String title) {
        TypedQuery<BlogPost> query = createEntityManager().createQuery("select n from BlogPost n where n.title=:title", BlogPost.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
}
