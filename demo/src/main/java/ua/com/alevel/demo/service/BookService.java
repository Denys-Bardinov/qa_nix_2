package ua.com.alevel.demo.service;

import ua.com.alevel.demo.entity.Book;

import java.util.List;

public interface BookService {
    void create(Book book);

    void update(Book book);

    void delete(String id);

    Book findById(String id);

    List<Book> findAll();
}
