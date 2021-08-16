package ua.com.alevel.controller;

import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class BookController {
    private BookService bookService = new BookService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create book, please enter 1");
        System.out.println("if you want update book, please enter 2");
        System.out.println("if you want delete book, please enter 3");
        System.out.println("if you want findById book, please enter 4");
        System.out.println("if you want findAll book, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findById(reader); break;
            case "5" : findAll(reader); break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("BookController.create");
        try {
            System.out.println("Please, enter book name");
            String name = reader.readLine();
            System.out.println("Please, enter book creation year");
            String yearString = reader.readLine();
            System.out.println("Please, enter comment");
            String comment = reader.readLine();
            int year = Integer.parseInt(yearString);
            Book book = new Book();
            book.setYear(year);
            book.setName(name);
            book.setComment(comment);
            bookService.create(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("BookController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter book name");
            String name = reader.readLine();
            System.out.println("Please, enter book year");
            String yearString = reader.readLine();
            System.out.println("Please, enter comment");
            String comment = reader.readLine();
            int year = Integer.parseInt(yearString);
            Book book = new Book();
            book.setId(id);
            book.setYear(year);
            book.setName(name);
            book.setComment(comment);
            bookService.update(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("BookController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            bookService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("BookController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Book book = bookService.findById(id);
            System.out.println("book = " + book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("BookController.findAll");
        Book[] books = bookService.findAll();
        for (Book book : books) {
            System.out.println("book = " + book);
        }
    }

}
