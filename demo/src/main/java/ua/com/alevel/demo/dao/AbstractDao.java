package ua.com.alevel.demo.dao;

import ua.com.alevel.demo.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDao {

    protected List<Author> authors = new ArrayList<>();

    protected void createAuthor(Author author) {
        author.setId(generateId());
        authors.add(author);
    }

    protected void updateAuthor(Author author) {
        if (existById(author.getId())) {
            Author current = findAuthorById(author.getId());
            current.setId(author.getId());
            current.setFirstname(author.getFirstname());
            current.setLastname(author.getLastname());
            current.setEmail(author.getEmail());
        }
    }

    protected void deleteDelete(String id) {
        authors.removeIf(author -> author.getId().equals(id));
    }

    protected Author findAuthorById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().get();
    }

    protected Author findAuthorByEmail(String email) {
        return authors.stream().filter(author -> author.getEmail().equals(email)).findFirst().get();
    }

    protected List<Author> findAllAuthors() {
        return authors;
    }

    protected boolean existAuthorByEmail(String email) {
        return authors.stream().anyMatch(authors -> authors.getEmail().equals(email));
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return authors.stream().anyMatch(authors -> authors.getId().equals(id));
    }

    public abstract Author findById(String id);
}
