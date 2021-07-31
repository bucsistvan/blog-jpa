package hu.ulyssys.java.course.database.jpa;

import hu.ulyssys.java.course.database.jpa.dao.AuthorDAO;
import hu.ulyssys.java.course.database.jpa.entity.Author;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AuthorDAO authorDAO = new AuthorDAO();
        Author author = new Author();
        author.setFirstName("András");
        author.setLastName("Nagy");
        author.setUserName("asffasdw");
        author.setCreatedDate(new Date(System.currentTimeMillis()));
        author.setLastModifiedDate(new Date(System.currentTimeMillis()));
        authorDAO.save(author);
        authorDAO.findAll().forEach(author1 -> {
            System.out.println(author1.getId() + " " + author1.getFirstName() + " " +author1.getLastName());
        });
    }
}
