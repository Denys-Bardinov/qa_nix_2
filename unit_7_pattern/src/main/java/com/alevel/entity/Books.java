package com.alevel.entity;

import java.util.Date;

public class Books {

    private String id;
    private String nameOfBook;
    private int count;
    private double price;
    private String authorID;
    private Date startDateOfAuthor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public static Builder newBooks() {
        return new Books().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(String id) {
            Books.this.id = id;
            return this;
        }

        public Builder setNameOfBook(String nameOfBook) {
            Books.this.nameOfBook = nameOfBook;
            return this;
        }

        public Builder setCount(int count) {
            Books.this.count = count;
            return this;
        }

        public Builder setPrice(double price) {
            Books.this.price = price;
            return this;
        }

        public Builder setAuthorID(String authorID) {
            Books.this.authorID = authorID;
            return this;
        }

        public Builder setStartDateOfAuthor(Date startDateOfAuthor) {
            Books.this.startDateOfAuthor = startDateOfAuthor;
            return this;
        }

        public Books build() {
            return Books.this;
        }
    }
}
