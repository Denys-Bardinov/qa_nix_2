package com.alevel.facade;

import com.alevel.dto.BooksRequestDto;
import com.alevel.dto.BooksResponseDto;

import java.util.List;

public interface BooksFacade {
    void create (BooksRequestDto dto);
    void update(BooksRequestDto dto, String id);
    void delete(String id);
    BooksResponseDto findById(String id);
    List<BooksResponseDto> findAll();
}
