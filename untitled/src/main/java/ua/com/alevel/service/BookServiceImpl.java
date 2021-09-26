package ua.com.alevel.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.com.alevel.demo.config.DaoFactory;
import ua.com.alevel.demo.dao.BookDao;
import ua.com.alevel.demo.entity.Book;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(@Qualifier("JsonUsersDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void create(Book book) {
        bookDao.create(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(String id) {
        bookDao.delete(id);
    }

    @Override
    public Book findById(String id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
}