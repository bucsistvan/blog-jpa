package hu.ulyssys.java.course.database.jpa.dao;

import hu.ulyssys.java.course.database.jpa.entity.Author;

import java.util.List;

public interface AuthorDAO {

    void save(Author author);

    void update(Author author);

    List<Author> findAll();

    List<Author> findByUserName(String userName);

}
