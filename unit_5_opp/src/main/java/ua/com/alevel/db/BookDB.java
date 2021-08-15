package ua.com.alevel.db;

import ua.com.alevel.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookDB {
    private List<Book> books = new ArrayList<>();

    public void create(Book book) {
        book.setId(generateId());
        books.add(book);
    }

    public void update(Book book) {
        Book current = books.stream().filter(b -> b.getId().equals(book.getId())).findFirst().get();
        current.setName(book.getName());
        current.setYear(book.getYear());
        current.setComment(book.getComment());
    }

    public void delete(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public Book findById(String id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst().get();

    }

    public List<Book> findAll() {
        return books;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if(books.stream().anyMatch(book ->  book.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
