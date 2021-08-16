package ua.com.alevel.dao;

import ua.com.alevel.db.BookDB;
import ua.com.alevel.entity.Book;

import java.util.List;

public class BookDao {
    private BookDB db = new BookDB();
    public void create(Book book) {
       db.create(book);
    }

    public void update(Book book) {
       db.update(book);
    }

    public void delete(String id) {
        db.delete(id);
    }

    public Book findById(String id) {
        return db.findById(id);

    }

    public List<Book> findAll() {
        return db.findAll();
    }
}