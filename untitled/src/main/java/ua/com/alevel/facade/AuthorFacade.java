package ua.com.alevel.demo.facade;

import ua.com.alevel.demo.dto.AuthorRequestDto;
import ua.com.alevel.demo.dto.AuthorResponseDto;

import java.util.List;

public interface AuthorFacade {
    void create(AuthorRequestDto dto);

    void update(AuthorRequestDto dto, String id);

    void delete(String id);

    AuthorResponseDto findById(String id);

    List<AuthorResponseDto> findAll();

}
