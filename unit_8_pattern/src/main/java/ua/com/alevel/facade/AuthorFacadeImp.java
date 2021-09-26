package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.AuthorRequestDto;
import ua.com.alevel.dto.AuthorResponseDto;
import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorFacadeImp implements AuthorFacade {

    private final AuthorService authorService;

    public AuthorFacadeImp(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void create(AuthorRequestDto dto) {
createOrUpdate(dto, null);
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
//        List<Author> authors = authorService.findAll();
//        List<AuthorResponseDto> dtoList = new ArrayList<>();
//        for (Author author : authors) {
//            dtoList.add(new AuthorResponseDto(author));
//        }
//        return dtoList;

        return authorService.findAll().stream().map(AuthorResponseDto::new).collect(Collectors.toList());
    }

    public void createOrUpdate(AuthorRequestDto dto, String id) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setEmail(dto.getEmail()); // добавь сюда проверку на существование автора для книги 1.26
        if (id == null) {
            authorService.create(author);
        } else {
            author.setId(id);
            authorService.update(author);
        }
    }
}
