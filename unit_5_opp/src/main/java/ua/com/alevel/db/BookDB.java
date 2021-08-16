package ua.com.alevel.db;

import ua.com.alevel.entity.Book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BookDB {
    private List<Book> books = new ArrayList<>();
    private List<Book> books1 = new LinkedList<>();
    private int size = 2;
    private int size2 = 4;
    private Book[] booksArray = new Book[size];
    private Book[] booksArray2 = new Book[size2];
    int lenght = 0;


//System.arraycopy(src, low, dest, destLow, length);

    public void create(Book book) {
        book.setId(generateId());
//        books.add(book);

        if (size > lenght) {
            booksArray[lenght] = book;
            lenght++;
        } else {
            System.arraycopy(booksArray, 0, booksArray2, 0, 2);
            booksArray2[lenght] = book;
            lenght++;
        }

        for (int i = 0; i < booksArray2.length; i++) {
            System.out.println(booksArray2[i]);
        }

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
        if (books.stream().anyMatch(book -> book.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
