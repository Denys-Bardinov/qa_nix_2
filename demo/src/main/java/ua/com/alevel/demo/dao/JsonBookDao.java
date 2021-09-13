package ua.com.alevel.demo.dao;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import ua.com.alevel.demo.config.FileTypeBook;
import ua.com.alevel.demo.entity.Book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonUsersDao")
public class JsonBookDao extends AbstractBookDao implements BookDao, FileIOBook {

    @Override
    public void create(Book book) {
        loadBooks();
        createBook(book);
        storeBooks();
    }

    @Override
    public void update(Book book) {
        loadBooks();
        updateBook(book);
        storeBooks();
    }

    @Override
    public void delete(String id) {
        loadBooks();
        deleteDelete(id);
        storeBooks();
    }


    @Override
    public Book findById(String id) {
        loadBooks();
        return findBookById(id);
    }


    @Override
    public List<Book> findAll() {
        loadBooks();
        return findAllBooks();
    }

    @Override
    public void loadBooks() {
        super.books.clear();
        try {
            String usersOut = FileUtils.readFileToString(new File(FileTypeBook.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.books = objectMapper.readValue(usersOut, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeBooks() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String usersOut = gson.toJson(books);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileTypeBook.JSON_TYPE.getPath()))) {
            writer.append(usersOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}