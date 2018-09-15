package com.sombra.edu.library.demo.service;

import com.sombra.edu.library.demo.dto.BookAuthorDto;

public interface BookAuthorService {

    BookAuthorDto getBookAuthor(Long bookAuthorId);

    BookAuthorDto createBookAuthor(BookAuthorDto bookAuthorDto);

    BookAuthorDto updateBookAuthor(Long bookId, BookAuthorDto bookAuthorDto);

    void deleteBookAuthor(Long bookAuthorId);
}
