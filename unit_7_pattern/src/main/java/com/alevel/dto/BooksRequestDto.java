package com.alevel.dto;

import java.util.Date;

public class BooksRequestDto {

    private String nameOfBook;
    private int count;
    private double price;
    private String authorID;
    private Date startDateOfAuthor;

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public Date getStartDateOfAuthor() {
        return startDateOfAuthor;
    }

    public void setStartDateOfAuthor(Date startDateOfAuthor) {
        this.startDateOfAuthor = startDateOfAuthor;
    }

}
