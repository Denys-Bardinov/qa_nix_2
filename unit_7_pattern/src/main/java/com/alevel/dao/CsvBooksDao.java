package com.alevel.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.alevel.config.FileType;
import com.alevel.entity.Books;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CsvBooksDao")
public class CsvBooksDao extends AbstractDaoBooks implements BooksDao, FileInterface {

    private final List<String[]> csvData = new ArrayList<>();

    @Override
    public void load() {
        try (CSVReader reader = new CSVReader(new FileReader(FileType.CSV_TYPE.getPath()))) {
            super.books.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    Books books = Books.newBooks()
                            .setId(re[0])
                            .setNameOfBook(re[1])
                            .setCount(Integer.valueOf(re[2]))
                            .setPrice(Double.valueOf(re[3]))
                            .setAuthorID(re[4])
                            .setStartDateOfAuthor(new Date(Long.parseLong(re[5])))
                            .build();
                    super.books.add(books);
                } catch (Exception e) {
                    System.out.println("e = " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store() {
        this.csvData.clear();
        writeHeader();
        for (Books u : super.books) {
            String[] currentBook = new String[6];
            currentBook[0] = u.getId();
            currentBook[1] = u.getNameOfBook();
            currentBook[2] = String.valueOf(u.getCount());
            currentBook[3] = String.valueOf(u.getPrice());
            currentBook[4] = u.getAuthorID();
            currentBook[5] = String.valueOf(u.getStartDateOfAuthor().getTime());
            csvData.add(currentBook);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(FileType.CSV_TYPE.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = {"id", "Name Of Book", "Count", "Price", "AuthorID", "StartDateOfAuthor"};
        csvData.add(header);
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
