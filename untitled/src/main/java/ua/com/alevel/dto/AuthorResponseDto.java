package ua.com.alevel.demo.dto;

import ua.com.alevel.demo.entity.Author;

public class AuthorResponseDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;


    public AuthorResponseDto(Author author) {
        this.id = author.getId();
        this.firstname = author.getFirstname();
        this.lastname = author.getLastname();
        this.email = author.getEmail();
    }


    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

}
