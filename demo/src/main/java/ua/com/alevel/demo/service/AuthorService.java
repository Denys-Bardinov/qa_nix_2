package ua.com.alevel.demo.service;

import ua.com.alevel.demo.entity.Author;

import java.util.List;

public interface AuthorService {
    void create(Author author);

    void update(Author author);

    void delete(String id);

    Author findByid(String id);

    List<Author> findAll();
}
