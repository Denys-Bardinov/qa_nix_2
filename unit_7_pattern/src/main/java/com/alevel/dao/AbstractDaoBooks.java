package com.alevel.dao;

import com.alevel.entity.Books;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoBooks {

    protected List<Books> books = new ArrayList<>();

    protected void createBooks(Books book) {
        book.setId(generateId());
        books.add(book);
    }

    protected void updateBooks(Books books) {
        if (existById(books.getId())) {
            Books current = findBooksById(books.getId());
            current.setId(books.getId());
            current.setNameOfBook(books.getNameOfBook());
            current.setCount(books.getCount());
            current.setPrice(books.getPrice());
            current.setAuthorID(books.getAuthorID());
            current.setStartDateOfAuthor(books.getStartDateOfAuthor());
        }
    }

    protected void deleteDelete(String id) {
        books.removeIf(books -> books.getId().equals(id));
    }

    protected Books findBooksById(String id) {
        return books.stream().filter(books -> books.getId().equals(id)).findFirst().get();
    }

    protected Books findBookByName(String nameOfBook) {
        return books.stream().filter(books -> books.getNameOfBook().equals(nameOfBook)).findFirst().get();
    }

    protected List<Books> findAllBooks() {
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
        return books.stream().anyMatch(books -> books.getId().equals(id));
    }

}
