package com.sombra.edu.library.demo.controller;

import com.sombra.edu.library.demo.dto.BookDto;
import com.sombra.edu.library.demo.entity.Book;
import com.sombra.edu.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public BookDto getBook(@PathVariable("bookId") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{bookId}")
    public BookDto updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        return bookService.updateBook(bookId, bookDto);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBoard(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    //Service method for task 5 - count books by genre
    @GetMapping("/task5/{genre}")
    public Integer countBooksByGenre(@PathVariable(value = "genre") String genre) {
        return bookService.countBooksByGenre(genre);
    }

}
