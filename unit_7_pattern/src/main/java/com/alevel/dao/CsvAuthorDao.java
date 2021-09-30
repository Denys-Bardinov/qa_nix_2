package com.alevel.dao;
import com.alevel.config.FileType;
import com.alevel.entity.Author;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("CsvAuthorDao")
public class CsvAuthorDao extends AbstractDaoAuthor implements AuthorDao, FileInterface{

    private final List<String[]> csvData = new ArrayList<>();

    @Override
    public void load() {
        try (CSVReader reader = new CSVReader(new FileReader(FileType.CSV_TYPE_S.getPath()))) {
            super.authores.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    Author author = Author.newAuthor()
                            .setId(re[0])
                            .setNameOfAuthor(re[1])
                            .setBookID(re[2])
                            .setNameBook(re[3])
                            .build();
                    super.authores.add(author);
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
        for (Author u : super.authores) {
            String[] currentAuthor = new String[4];
            currentAuthor[0] = u.getId();
            currentAuthor[1] = u.getNameOfAuthor();
            currentAuthor[2] = u.getBookID();
            currentAuthor[3] = u.getNameBook();
            csvData.add(currentAuthor);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(FileType.CSV_TYPE_S.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = {"id", "Name Of Author", "BookID", "Description"};
        csvData.add(header);
    }

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

}
