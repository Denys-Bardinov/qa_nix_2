package ua.com.alevel.demo.dao;


import ua.com.alevel.demo.entity.Book;

import java.util.List;

public interface BookDao {
    void create(Book book);

    void update(Book book);

    void delete(String id);

    Book findById(String id);

    List<Book> findAll();

}

