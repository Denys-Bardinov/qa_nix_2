package com.alevel.entity;

public class Author {

    private String id;
    private String nameOfAuthor;
    private String bookID;
    private String nameBook;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public static Author.Builder newAuthor() {
        return new Author().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Author.Builder setId(String id) {
            Author.this.id = id;
            return this;
        }

        public Author.Builder setNameOfAuthor(String nameOfAuthor) {
            Author.this.nameOfAuthor = nameOfAuthor;
            return this;
        }

        public Author.Builder setBookID(String bookID) {
            Author.this.bookID = bookID;
            return this;
        }

        public Author.Builder setNameBook(String nameBook) {
            Author.this.nameBook = nameBook;
            return this;
        }

        public Author build() {
            return Author.this;
        }
    }
}
