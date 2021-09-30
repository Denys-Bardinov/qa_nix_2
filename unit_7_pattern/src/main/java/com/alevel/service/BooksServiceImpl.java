package com.alevel.service;

import com.alevel.config.DaoFactory;
import com.alevel.dao.BooksDao;
import com.alevel.entity.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksDao booksDao = DaoFactory.getInstance().getBooksDao();

    @Override
    public void create(Books books) {
        booksDao.create(books);
    }

    @Override
    public void update(Books books) {
        booksDao.update(books);
    }

    @Override
    public void delete(String id) {
        booksDao.delete(id);
    }

    @Override
    public Books findById(String id) {
        return booksDao.findById(id);
    }

    @Override
    public List<Books> findAll() {
        return booksDao.findAll();
    }
}
