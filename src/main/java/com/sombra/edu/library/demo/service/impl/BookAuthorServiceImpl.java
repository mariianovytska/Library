package com.sombra.edu.library.demo.service.impl;

import com.sombra.edu.library.demo.converter.BookAuthorConverter;
import com.sombra.edu.library.demo.dto.BookAuthorDto;
import com.sombra.edu.library.demo.entity.Book;
import com.sombra.edu.library.demo.entity.BookAuthor;
import com.sombra.edu.library.demo.exception.ResourceNotFoundException;
import com.sombra.edu.library.demo.repository.BookAuthorRepository;
import com.sombra.edu.library.demo.service.BookAuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookAuthorServiceImpl implements BookAuthorService {

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookAuthorConverter bookAuthorConverter;

    @Override
    public BookAuthorDto getBookAuthor(Long bookAuthorId) {
        log.info(String.format("Getting book-author with id %d", bookAuthorId));
        return bookAuthorConverter.convertToDto(getBookAuthorById(bookAuthorId));
    }

    @Override
    public BookAuthorDto createBookAuthor(BookAuthorDto bookAuthorDto) {
        log.info("Creating book-author: " + bookAuthorDto);
        return bookAuthorConverter.convertToDto(bookAuthorRepository.save(
                bookAuthorConverter.convertToEntity(bookAuthorDto)));
    }

    @Override
    public BookAuthorDto updateBookAuthor(Long bookAuthorId, BookAuthorDto bookAuthorDto) {
        BookAuthor bookAuthor = getBookAuthorById(bookAuthorId);
        BookAuthorDto bookAuthorDto1 = bookAuthorConverter.convertToDto(bookAuthor);
        bookAuthorDto1.setBookId(bookAuthorDto.getBookId());
        bookAuthorDto1.setAuthorId(bookAuthorDto.getAuthorId());
        log.info("Updating book-author: " + bookAuthorDto);
        return bookAuthorConverter.convertToDto(bookAuthorRepository
                .save(bookAuthorConverter.convertToEntity(bookAuthorDto1)));
    }

    @Override
    public void deleteBookAuthor(Long bookAuthorId) {
        log.info(String.format("Deleting book with id %d", bookAuthorId));
        bookAuthorRepository.delete(getBookAuthorById(bookAuthorId));
    }

    private BookAuthor getBookAuthorById(Long bookAuthorId) {
        return bookAuthorRepository.findById(bookAuthorId).orElseThrow(() ->
                new ResourceNotFoundException("Book-Author", "id", bookAuthorId));
    }
}
