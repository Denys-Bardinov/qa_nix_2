package com.alevel.controller;

import com.alevel.dto.BooksRequestDto;
import com.alevel.dto.BooksResponseDto;
import com.alevel.dto.ResponseContainer;
import com.alevel.facade.BooksFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BooksFacade booksFacade;

    public BooksController(BooksFacade booksFacade) {
        this.booksFacade = booksFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody BooksRequestDto dto) {
        booksFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody BooksRequestDto dto, @PathVariable String id) {
        booksFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        booksFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<BooksResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(booksFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<BooksResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(booksFacade.findAll()));
    }
}
