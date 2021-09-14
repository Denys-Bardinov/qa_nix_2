package ua.com.alevel.demo.dao;

import ua.com.alevel.demo.entity.Author;
import ua.com.alevel.demo.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractBookDao {

    protected List<Book> books = new ArrayList<>();
    protected List<Author> authors = new ArrayList<>();

    protected void createBook(Book book) {
        book.setId(generateId());
        books.add(book);
    }

    protected void updateBook(Book book) {
        if (existById(book.getAuthorId())) {
            Book current = findBookById(book.getId());
            current.setId(book.getId());
            current.setFirstname(book.getFirstname());
        }
    }

    protected void deleteDelete(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    protected Book findBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().get();
    }


    protected List<Book> findAllBooks() {
        return books;
    }


    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return authors.stream().anyMatch(authors -> authors.getId().equals(id));
    }

    public abstract Book findById(String id);
}
