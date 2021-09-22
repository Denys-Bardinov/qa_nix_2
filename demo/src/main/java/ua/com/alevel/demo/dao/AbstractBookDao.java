package ua.com.alevel.demo.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import ua.com.alevel.demo.config.FileType;
import ua.com.alevel.demo.config.FileTypeBook;
import ua.com.alevel.demo.entity.Author;
import ua.com.alevel.demo.entity.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public abstract class AbstractBookDao {

    protected List<Book> books = new ArrayList<>();
    protected List<Author> authors = new ArrayList<>();





    protected void createBook(Book book) {

                book.setId(generateId());
                books.add(book);



    }

//    protected void updateBook(Book book) {
//        if (existById(book.getAuthorId())) {
//            Book current = findBookById(book.getId());
//            current.setId(book.getId());
//            current.setFirstname(book.getFirstname());
//        }
//    }

    protected void deleteDelete(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    protected Book findBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().get();
    }


    protected List<Book> findAllBooks() {
        return books;
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

    public abstract Book findById(String id);


//    private  static boolean existByAuthorIdGetList(String id) {
//
//            JsonParser jsonParser = new JsonParser();
//            FileReader reader;
//
//            {
//                try
//                {
//                    reader = new FileReader("author.json");
//                    Object obj = jsonParser.parse(reader);
//                    JsonArray empList = (JsonArray) obj;
//                    empList.forEach(emp->parseEmpObj((JsonObject) emp));
//                    ArrayList<JsonElement> b = new ArrayList(2);
//                    for (int i = 0; i < empList.size(); i++) {
//                        b.add(empList.get(i));
//                    }
//                    String r = "";
//                    for (int i =0; i < b.size(); i++) {
//                        r = r + b.get(i).toString();
//                    }
//                    String[] strings = new String[100];
//                    strings = r.split("\"");
//                    String[] idSplit = new String[100];
//                    for (int i =0; i < strings.length; i++) {
//                        if(strings[i].length() == 36) {
//                            idSplit[i] = strings[i];
//                        }
//                    }
//
//                    List authors = Arrays.asList(idSplit);
//                    boolean idResultBoolean;
//                    for (int i = 0; i < idSplit.length; i++) {
//                        if(idSplit[i] == id) {
//                            idResultBoolean= true;
//                            return idResultBoolean;
//                        }
//                        else {
//                             idResultBoolean = false;
//                             return idResultBoolean;
//                        }
//                    }
//
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//
//            }
//       return
//    }
//
//        private static void parseEmpObj(JsonObject emp){
////        String[] idList = new String[2];
//
//            emp.keySet().forEach(keyStr->
//            {
//                Object keyValue = emp.get(keyStr);
//            });
//
//
//
//
//        }
}
