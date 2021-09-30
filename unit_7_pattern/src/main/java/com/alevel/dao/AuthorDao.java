package com.alevel.dao;

import com.alevel.entity.Author;

import java.util.List;

public interface AuthorDao {

    void create (Author author);
    void update (Author author);
    void delete (String id);
    Author findById (String id);
    List<Author> findAll();
 }
