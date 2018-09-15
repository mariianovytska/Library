package com.sombra.edu.library.demo.service;

import com.sombra.edu.library.demo.dto.BookDto;
import com.sombra.edu.library.demo.entity.Book;

import java.util.List;

public interface BookService {

    BookDto getBook(Long bookId);

    BookDto createBook(BookDto bookDto);

    BookDto updateBook(Long bookId, BookDto bookDto);

    void deleteBook(Long bookId);

    List<BookDto> getAllBooks();

    Integer countBooksByGenre(String genre);
}
