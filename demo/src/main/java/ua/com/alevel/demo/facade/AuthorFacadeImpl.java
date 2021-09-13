package ua.com.alevel.demo.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.demo.dto.AuthorRequestDto;
import ua.com.alevel.demo.dto.AuthorResponseDto;
import ua.com.alevel.demo.entity.Author;
import ua.com.alevel.demo.service.AuthorService;

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
        createOrUpdate(dto, null);
    }

    @Override
    public void update(AuthorRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        authorService.delete(id);
    }

    @Override
    public AuthorResponseDto findById(String id) {
        return new AuthorResponseDto(authorService.findByid(id));
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        return authorService.findAll().stream().map(AuthorResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(AuthorRequestDto dto, String id) {
        Author author = new Author();
        author.setFirstname(dto.getFirstname());
        author.setLastname(dto.getLastname());
        author.setEmail(dto.getEmail());
        if (id == null) {
            authorService.create(author);
        } else {
            author.setId(id);
            authorService.update(author);
        }
    }
}