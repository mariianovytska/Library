package com.sombra.edu.library.demo.controller;

import com.sombra.edu.library.demo.dto.BookAuthorDto;
import com.sombra.edu.library.demo.service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book-author")
public class BookAuthorController {

    @Autowired
    private BookAuthorService bookAuthorService;

    @GetMapping("/{bookAuthorId}")
    public BookAuthorDto getBookAuthor(@PathVariable("bookAuthorId") Long bookAuthorId) {
        return bookAuthorService.getBookAuthor(bookAuthorId);
    }

    @PostMapping
    public BookAuthorDto createBookAuthor(@RequestBody BookAuthorDto bookAuthorDto) {
        return bookAuthorService.createBookAuthor(bookAuthorDto);
    }

    @PutMapping("/{bookId}")
    public BookAuthorDto updateBookAuthor(@PathVariable Long bookAuthorId, @RequestBody BookAuthorDto bookAuthorDto) {
        return bookAuthorService.updateBookAuthor(bookAuthorId, bookAuthorDto);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBoard(@PathVariable Long bookAuthorId) {
        bookAuthorService.deleteBookAuthor(bookAuthorId);
        }
}
