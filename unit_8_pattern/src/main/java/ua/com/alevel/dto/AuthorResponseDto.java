package ua.com.alevel.dto;

import ua.com.alevel.entity.Author;

public class AuthorResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public AuthorResponseDto(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.email = author.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
