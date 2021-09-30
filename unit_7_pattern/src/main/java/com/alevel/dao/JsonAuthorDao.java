package com.alevel.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.alevel.config.FileType;
import com.alevel.entity.Author;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonAuthorDao")
public class JsonAuthorDao extends AbstractDaoAuthor implements AuthorDao, FileInterface {
    @Override
    public void create(Author author) {
        load();
        createAuthor(author);
        store();
    }

    @Override
    public void update(Author author) {
        load();
        updateAuthor(author);
        store();
    }

    @Override
    public void delete(String id) {
        load();
        deleteDelete(id);
        store();
    }

    @Override
    public Author findById(String id) {
        load();
        return findAuthorById(id);
    }

    @Override
    public List<Author> findAll() {
        load();
        return findAllAuthor();
    }

    @Override
    public void load() {
        super.authores.clear();
        try {
            String authorOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE_S.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.authores = objectMapper.readValue(authorOut, new TypeReference<>() {
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
        String authorOut = gson.toJson(authores);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE_S.getPath()))) {
            writer.append(authorOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
