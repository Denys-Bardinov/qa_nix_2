package ua.com.alevel.dao;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import ua.com.alevel.entity.Author;

import java.util.List;

public interface AuthorDao {

    void create(Author author);
    void update(Author author);
    void delete(String id);
    Author findById(String id);
    boolean existByEmail(String email);
    List<Author> findAll();
}
