package ua.com.alevel.demo.dao;

import ua.com.alevel.demo.entity.Author;

import java.util.List;

public interface AuthorDao {
    void create(Author author);

    void update(Author author);

    void delete(String id);

    Author findByid(String id);

    boolean existByEmail(String email);

    List<Author> findAll();

}
