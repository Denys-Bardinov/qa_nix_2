package ua.com.alevel.demo.dao;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.demo.config.FileType;
import ua.com.alevel.demo.entity.Author;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonUserDao")
public class JsonAuthorDao extends AbstractDao implements AuthorDao, FileIO {

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
    public Author findByid(String id) {
        loadAuthors();
        return findAuthorById(id);
    }


    @Override
    public Author findById(String id) {
        loadAuthors();
        return findAuthorById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        loadAuthors();
        return existAuthorByEmail(email);
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
            String usersOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.authors = objectMapper.readValue(usersOut, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeAuthors() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String usersOut = gson.toJson(authors);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE.getPath()))) {
            writer.append(usersOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}