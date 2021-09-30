package com.alevel.service;

import com.alevel.config.DaoFactory;
import com.alevel.dao.AuthorDao;
import com.alevel.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao = DaoFactory.getInstance().getAuthorDao();

    @Override
    public void create(Author author) {
        authorDao.create(author);

    }

    @Override
    public void update(Author author) {
        authorDao.update(author);
    }

    @Override
    public void delete(String id) {
        authorDao.delete(id);
    }

    @Override
    public Author findById(String id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
