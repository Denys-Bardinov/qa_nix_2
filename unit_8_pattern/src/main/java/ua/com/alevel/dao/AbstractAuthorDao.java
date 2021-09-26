package ua.com.alevel.dao;

import ua.com.alevel.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractAuthorDao {

        protected List<Author> authors = new ArrayList<>();

        protected void createAuthor(Author author) {
            author.setId(generateId());
            authors.add(author);
        }

        protected void updateAuthor(Author author) {
            if (existById(author.getId())) {
                Author current = findAuthorById(author.getId());
                current.setId(author.getId());
                current.setFirstName(author.getFirstName());
                current.setLastName(author.getLastName());
                current.setEmail(author.getEmail());
            }
        }

        protected void deleteDelete(String id) {
            authors.removeIf(author -> author.getId().equals(id));
        }

        protected Author findAuthorById(String id) {
            return authors.stream().filter(author -> author.getId().equals(id)).findFirst().get();
        }

        protected Author findUserByEmail(String email) {
            return authors.stream().filter(author -> author.getEmail().equals(email)).findFirst().get();
        }

        protected List<Author> findAllAuthors() {
            return authors;
        }

        protected boolean existUserByEmail(String email) {
            return authors.stream().anyMatch(author -> author.getEmail().equals(email));
        }

        private String generateId() {
            String id = UUID.randomUUID().toString();
            if (existById(id)) {
                return generateId();
            }
            return id;
        }

        private boolean existById(String id) {
            return authors.stream().anyMatch(author -> author.getId().equals(id));
        }
    }

