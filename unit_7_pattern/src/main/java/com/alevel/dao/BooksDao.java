package com.alevel.dao;

import com.alevel.entity.Books;

import java.util.List;

public interface BooksDao {

    void create (Books books);
    void update (Books books);
    void delete (String id);
    Books findById (String id);
    List<Books> findAll();
 }
