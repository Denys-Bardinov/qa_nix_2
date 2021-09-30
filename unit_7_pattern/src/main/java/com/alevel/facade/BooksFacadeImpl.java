package com.alevel.facade;

import com.alevel.dto.BooksRequestDto;
import com.alevel.dto.BooksResponseDto;
import com.alevel.entity.Books;
import com.alevel.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksFacadeImpl implements BooksFacade {

    private final BooksService booksService;

    public BooksFacadeImpl(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public void create(BooksRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(BooksRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        booksService.delete(id);
    }

    @Override
    public BooksResponseDto findById(String id) {
        return new BooksResponseDto(booksService.findById(id));
    }

    @Override
    public List<BooksResponseDto> findAll() {
        return booksService.findAll().stream().map(BooksResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(BooksRequestDto dto, String id) {
        Books book = new Books();
        book.setNameOfBook(dto.getNameOfBook());
        book.setCount(dto.getCount());
        book.setPrice(dto.getPrice());
        book.setAuthorID(dto.getAuthorID());
        book.setStartDateOfAuthor(dto.getStartDateOfAuthor());
            if (id == null) {
            booksService.create(book);
        } else {
            book.setId(id);
            booksService.update(book);
        }
    }
}
