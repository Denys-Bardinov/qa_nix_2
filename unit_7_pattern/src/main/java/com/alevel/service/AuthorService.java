package com.alevel.service;

import com.alevel.entity.Author;

import java.util.List;

public interface AuthorService {

    void create(Author author);

    void update(Author author);

    void delete(String id);

    Author findById(String id);

    List<Author> findAll();
}
