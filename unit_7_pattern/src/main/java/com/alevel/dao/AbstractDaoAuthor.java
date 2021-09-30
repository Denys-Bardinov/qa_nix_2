package com.alevel.dao;

import com.alevel.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDaoAuthor {

    protected List<Author> authores = new ArrayList<>();

    protected void createAuthor(Author author) {
        author.setId(generateId());
        authores.add(author);
    }

    protected void updateAuthor(Author author) {
        if (existById(author.getId())) {
            Author current = findAuthorById(author.getId());
            current.setId(author.getId());
            current.setNameOfAuthor(author.getNameOfAuthor());
            current.setBookID(author.getBookID());
            current.setNameBook(author.getNameBook());
        }
    }

    protected void deleteDelete(String id) {
        authores.removeIf(author -> author.getId().equals(id));
    }

    protected Author findAuthorById(String id) {
        return authores.stream().filter(author -> author.getId().equals(id)).findFirst().get();
    }

    protected Author findAuthorByName(String nameOfAuthor) {
        return authores.stream().filter(author -> author.getNameOfAuthor().equals(nameOfAuthor)).findFirst().get();
    }

    protected List<Author> findAllAuthor() {
        return authores;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return authores.stream().anyMatch(author -> author.getId().equals(id));
    }

}
