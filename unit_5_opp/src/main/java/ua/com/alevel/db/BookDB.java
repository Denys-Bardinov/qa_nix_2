package ua.com.alevel.db;

import ua.com.alevel.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookDB {
    private List<Book> books = new ArrayList<>();
    private int size = 4;
    private int size2 = 8;
    private Book[] booksArray = new Book[size];
    private Book[] booksArray2 = new Book[size2];
    int lenght = 0;
    int index = -1;


    public void create(Book book) {
        book.setId(generateId());


        if (size > lenght) {
            booksArray[lenght] = book;
            lenght++;
        } else {
            System.arraycopy(booksArray, 0, booksArray2, 0, 2);
            booksArray2[lenght] = book;
            lenght++;
        }
    }


    public void update(Book book) {
        Book current = books.stream().filter(b -> b.getId().equals(book.getId())).findFirst().get();
        current.setName(book.getName());
        current.setYear(book.getYear());
        current.setComment(book.getComment());
    }

    public void delete(String id) {
        // books.removeIf(book -> book.getId().equals(id));
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        for (int j = index; j < booksArray.length - 1; j++) {
            booksArray[j] = booksArray[j + 1];
        }
        booksArray[booksArray.length - 1] = null;


    }


    public Book findById(String id) {
        Book result = null;
        int ind = 0;
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i].getId().equals(id)) {
                ind = i;
                break;
            }
        }
        result = booksArray[ind];
        return result;
    }


    public Book[] findAll() {
        return booksArray;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (books.stream().anyMatch(book -> book.getId().equals(id))) {
            return generateId();
        }
        return id;
    }


}