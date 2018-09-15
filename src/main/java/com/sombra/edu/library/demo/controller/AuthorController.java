package com.sombra.edu.library.demo.controller;

import com.sombra.edu.library.demo.dto.AuthorDto;
import com.sombra.edu.library.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{authorId}")
    public AuthorDto getAuthor(@PathVariable("authorId") Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }

    @PutMapping("/{authorId}")
    public AuthorDto updateAuthor(@PathVariable Long authorId, @RequestBody AuthorDto authorDto) {
        return authorService.updateAuthor(authorId, authorDto);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    //Controller method for task 2 - getting authors older then 55 years
    @GetMapping("/task2")
    public List<AuthorDto> getAllAuthorsOlderThen55() {
        return authorService.getAuthorsOlderThen55();
    }

    //Controller method for task 2 - getting authors with more then 1 book
    @GetMapping("/task3")
    public List<AuthorDto> getAuthorsHavingMore1Book() {
        return authorService.getAuthorsHavingMore1Book();
    }

    //Controller method for task 4 - getting authors with max number of books
    @GetMapping("/task4")
    public List<AuthorDto> getAuthorsHavingMaxBooks() {
        return authorService.getAuthorsHavingMaxBooks();
    }
}
