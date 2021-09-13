package ua.com.alevel.demo.dto;

import ua.com.alevel.demo.entity.Book;

public class BookResponseDto {
    private String id;
    private String name;


    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.name = book.getFirstname();
    }


    public String getId() {
        return id;
    }

    public String getFirstname() {
        return name;
    }


}

