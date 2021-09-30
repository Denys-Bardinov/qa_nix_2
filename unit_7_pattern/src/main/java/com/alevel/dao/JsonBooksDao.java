package com.alevel.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.alevel.config.FileType;
import com.alevel.entity.Books;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonBooksDao")
public class JsonBooksDao extends AbstractDaoBooks implements BooksDao, FileInterface {


    @Override
    public void load() {
        super.books.clear();
        try {
            String booksOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.books = objectMapper.readValue(booksOut, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store() {
        Gson gson = new GsonBuilder()
           .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
            .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String booksOut = gson.toJson(books);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE.getPath()))) {
            writer.append(booksOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Books books) {
        load();
        createBooks(books);
        store();
    }

    @Override
    public void update(Books books) {
        load();
        updateBooks(books);
        store();
    }

    @Override
    public void delete(String id) {
        load();
        deleteDelete(id);
        store();
    }

    @Override
    public Books findById(String id) {
        load();
        return findBooksById(id);
    }

    @Override
    public List<Books> findAll() {
        load();
        return findAllBooks();
    }

}
