package com.sombra.edu.library.demo.service.impl;

import com.sombra.edu.library.demo.converter.BookConverter;
import com.sombra.edu.library.demo.dto.BookDto;
import com.sombra.edu.library.demo.entity.Book;
import com.sombra.edu.library.demo.exception.ResourceNotFoundException;
import com.sombra.edu.library.demo.repository.BookRepository;
import com.sombra.edu.library.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookConverter bookConverter;

    @Override
    public BookDto getBook(Long bookId) {
        log.info(String.format("Getting book with id %d", bookId));
        return bookConverter.convertToDto(getBookByBookId(bookId));
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        log.info("Creating book: " + bookDto);
        return bookConverter.convertToDto(bookRepository.save(
                bookConverter.convertToEntity(bookDto)));
    }

    @Override
    public BookDto updateBook(Long bookId, BookDto bookDto) {
        Book book = getBookByBookId(bookId);
        book.setName(bookDto.getName());
        book.setPublished(bookDto.getPublished());
        book.setGenre(bookDto.getGenre());
        book.setRating(bookDto.getRating());
        log.info("Updating book: " + book);
        return bookConverter.convertToDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long bookId) {
        log.info(String.format("Deleting book with id %d", bookId));
        bookRepository.delete(getBookByBookId(bookId));
    }

    @Override
    public List<BookDto> getAllBooks(){
        log.info("Getting all books");
        return bookConverter.convertToDto(bookRepository.findAll());
    }

    //Service method for task 5 - count books by genre
    @Override
    public Integer countBooksByGenre(String genre){
        log.info("Counting all books by genre");
        return bookRepository.countAllByGenre(genre);
    }

    private Book getBookByBookId(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() ->
                new ResourceNotFoundException("Book", "id", bookId));
    }
}
