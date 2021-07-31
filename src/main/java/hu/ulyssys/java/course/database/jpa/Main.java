package hu.ulyssys.java.course.database.jpa;

import hu.ulyssys.java.course.database.jpa.dao.AuthorDAO;
import hu.ulyssys.java.course.database.jpa.dao.BlogPostDAO;
import hu.ulyssys.java.course.database.jpa.entity.Author;
import hu.ulyssys.java.course.database.jpa.entity.BlogPost;
import hu.ulyssys.java.course.database.jpa.entity.Category;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    @Inject
    private AuthorDAO authorDAO;

    @Inject
    private BlogPostDAO blogPostDAO;

    public static void main(String[] args) {
        CDI<Object> cdi = CDI.getCDIProvider().initialize();
        Main main = cdi.select(Main.class).get();
        main.main(Arrays.asList(args));
    }
    protected void main(List<String> args) {
        Author author = new Author();
        author.setFirstName("Sándor");
        author.setLastName("Kis");
        author.setUserName("asffasdw");
        author.setCreatedDate(new Date(System.currentTimeMillis()));
        author.setLastModifiedDate(new Date(System.currentTimeMillis()));
        authorDAO.save(author);
        authorDAO.findAll().forEach(author1 -> {
            System.out.println(author1.getId() + " " + author1.getFirstName() + " " +author1.getLastName());
        });

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("A programok világa");
        blogPost.setCategory(Category.SQL);
        blogPost.setContent("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        blogPost.setCreatedDate(new Date(System.currentTimeMillis()));
        blogPost.setLastModifiedDate(new Date(System.currentTimeMillis()));
        blogPost.setPublishedDate(new Date(System.currentTimeMillis()));
        blogPostDAO.save(blogPost);
        blogPostDAO.findAll().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getTitle() + " " +blogPost1.getCategory());
        });
    }
}
