package com.alevel.facade;

import com.alevel.dto.AuthorRequestDto;
import com.alevel.dto.AuthorResponseDto;
import com.alevel.entity.Author;
import com.alevel.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorFacadeImpl implements AuthorFacade {

    private final AuthorService authorService;

    public AuthorFacadeImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void create(AuthorRequestDto dto) {
        createOrUpdate(dto,null);
    }

    @Override
    public void update(AuthorRequestDto dto, String id) {
        createOrUpdate(dto,id);
    }

    @Override
    public void delete(String id) {
        authorService.delete(id);
    }

    @Override
    public AuthorResponseDto findById(String id) {
        return new AuthorResponseDto(authorService.findById(id));
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        return authorService.findAll().stream().map(AuthorResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(AuthorRequestDto dto, String id) {
        Author author = new Author();
        author.setNameOfAuthor(dto.getNameOfAuthor());
        author.setBookID(dto.getBookID());
        author.setNameBook(dto.getNameBook());
        if (id == null) {
            authorService.create(author);
        } else {
            author.setId(id);
            authorService.update(author);
        }
    }
}
