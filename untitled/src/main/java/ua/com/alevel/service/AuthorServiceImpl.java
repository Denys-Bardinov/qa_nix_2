package ua.com.alevel.demo.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.demo.config.DaoFactory;
import ua.com.alevel.demo.dao.AuthorDao;
import ua.com.alevel.demo.entity.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao = DaoFactory.getInstance().getAuthorDao();


    @Override
    public void create(Author author) {
        if (!authorDao.existByEmail(author.getEmail())) {
            authorDao.create(author);
        }
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
    public Author findByid(String id) {
        return authorDao.findByid(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
