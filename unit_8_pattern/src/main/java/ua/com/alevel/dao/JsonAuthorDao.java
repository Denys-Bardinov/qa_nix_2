package ua.com.alevel.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.FileTypeAuthor;
import ua.com.alevel.entity.Author;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonUsersDao")
public class JsonAuthorDao extends AbstractAuthorDao implements AuthorDao, FileIO {

    @Override
    public void create(Author author) {
        loadAuthors();
        createAuthor(author);
        storeAuthors();
    }

    @Override
    public void update(Author author) {
        loadAuthors();
        updateAuthor(author);
        storeAuthors();
    }

    @Override
    public void delete(String id) {
        loadAuthors();
        deleteDelete(id);
        storeAuthors();
    }

    @Override
    public Author findById(String id) {
        loadAuthors();
        return findAuthorById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        loadAuthors();
        return existUserByEmail(email);
    }

    @Override
    public List<Author> findAll() {
        loadAuthors();
        return findAllAuthors();
    }

    @Override
    public void loadAuthors() {
        super.authors.clear();
        try {
            String authorsOut = FileUtils.readFileToString(new File(FileTypeAuthor.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.authors = objectMapper.readValue(authorsOut, new TypeReference<>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeAuthors() {
        Gson gson = new Gson();
        String authorsOut = gson.toJson(authors);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileTypeAuthor.JSON_TYPE.getPath()))) {
            writer.append(authorsOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
