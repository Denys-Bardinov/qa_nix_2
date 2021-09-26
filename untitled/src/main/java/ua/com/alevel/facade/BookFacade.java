package ua.com.alevel.demo.facade;


import ua.com.alevel.demo.dto.BookRequestDto;
import ua.com.alevel.demo.dto.BookResponseDto;

import java.util.List;

public interface BookFacade {
    void create(BookRequestDto dto);

    void update(BookRequestDto dto, String id);

    void delete(String id);

    BookResponseDto findById(String id);

    List<BookResponseDto> findAll();

}
