package ua.com.alevel.demo.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.demo.dto.BookRequestDto;
import ua.com.alevel.demo.dto.BookResponseDto;
import ua.com.alevel.demo.entity.Book;
import ua.com.alevel.demo.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookFacadeImpl implements BookFacade {

    private final BookService bookService;

    public BookFacadeImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void create(BookRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(BookRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        bookService.delete(id);
    }

    @Override
    public BookResponseDto findById(String id) {
        return new BookResponseDto(bookService.findById(id));
    }

    @Override
    public List<BookResponseDto> findAll() {
        List<Book> books = bookService.findAll();
        List<BookResponseDto> dtoList = new ArrayList<>();
        for (Book book : books) {
            dtoList.add(new BookResponseDto(book));
        }
        return dtoList;
    }

    public void createOrUpdate(BookRequestDto dto, String id) {
        Book book = new Book();
        book.setFirstname(dto.getFirstname());
//        book.setAuthorId(dto.getAuthorId());
        if (id == null) {
            bookService.create(book);
        } else {
            book.setId(id);
            bookService.update(book);
        }
    }
}