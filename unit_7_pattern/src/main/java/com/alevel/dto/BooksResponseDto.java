package com.alevel.dto;

import com.alevel.entity.Books;

import java.util.Date;

public class BooksResponseDto {

    private String id;
    private String nameOfBook;
    private int count;
    private double price;
    private String authorID;
    private Date startDateOfAuthor;
    private double sum;

    public BooksResponseDto(Books books) {
        this.id = books.getId();
        this.nameOfBook = books.getNameOfBook();
        this.count = books.getCount();
        this.price = books.getPrice();
        this.authorID = books.getAuthorID();
        this.startDateOfAuthor = books.getStartDateOfAuthor();
        this.sum = generateSum(books);
    }

    private double generateSum(final Books books) {
        double totalSum = count * price;
        return totalSum;
    }

    public String getId() {
        return id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthorID() {
        return authorID;
    }

    public Date getStartDateOfAuthor() {
        return startDateOfAuthor;
    }

    public double getSum() {
        return sum;
    }
}
