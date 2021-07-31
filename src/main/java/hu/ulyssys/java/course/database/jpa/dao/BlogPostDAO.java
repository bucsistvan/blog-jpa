package hu.ulyssys.java.course.database.jpa.dao;

import hu.ulyssys.java.course.database.jpa.entity.BlogPost;

import java.util.List;

public interface BlogPostDAO {

    void save(BlogPost blogPost);

    void update(BlogPost blogPost);

    List<BlogPost> findAll();

    List<BlogPost> findByTitle(String title);

}
