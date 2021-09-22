package ua.com.alevel.demo.dto;

import ua.com.alevel.demo.entity.Book;

public class BookResponseDto {
    private String id;
    private String name;
    private String authorId;

    public void setId(String id) {
        this.id = id;
    }



    public void setFirstName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.name = book.getFirstname();
//        this.authorId = book.getAuthorId();
    }


    public String getId() {
        return id;
    }

    public String getFirstname() {
        return name;
    }


}

