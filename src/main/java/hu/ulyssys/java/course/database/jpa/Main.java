package hu.ulyssys.java.course.database.jpa;

import hu.ulyssys.java.course.database.jpa.dao.AuthorDAO;
import hu.ulyssys.java.course.database.jpa.dao.BlogPostDAO;
import hu.ulyssys.java.course.database.jpa.entity.Author;
import hu.ulyssys.java.course.database.jpa.entity.BlogPost;
import hu.ulyssys.java.course.database.jpa.entity.Category;

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


        BlogPostDAO blogPostDAO = new BlogPostDAO();
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("Felhők tánca");
        blogPost.setCategory(Category.valueOf("JAVA"));
        blogPost.setContent("ascacascascdvsdasasc");
        blogPost.setCreatedDate(new Date(System.currentTimeMillis()));
        blogPost.setLastModifiedDate(new Date(System.currentTimeMillis()));
        blogPost.setPublishedDate(new Date(System.currentTimeMillis()));
        blogPostDAO.save(blogPost);
        blogPostDAO.findAll().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getTitle() + " " +blogPost1.getCategory());
        });
    }
}
