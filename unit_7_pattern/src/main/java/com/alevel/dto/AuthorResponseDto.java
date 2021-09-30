package com.alevel.dto;

import com.alevel.entity.Author;

public class AuthorResponseDto {

    private String id;
    private String nameOfAuthor;
    private String bookID;
    private String nameBook;

    public AuthorResponseDto(Author author) {
        this.id = author.getId();
        this.nameOfAuthor = author.getNameOfAuthor();
        this.bookID = author.getBookID();
        this.nameBook = author.getNameBook();
    }

    public String getId() {
        return id;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public String getBookID() {
        return bookID;
    }

    public String getNameBook() {
        return nameBook;
    }
}
