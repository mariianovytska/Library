package com.sombra.edu.library.demo.converter.impl;

import com.sombra.edu.library.demo.converter.BookAuthorConverter;
import com.sombra.edu.library.demo.dto.AuthorDto;
import com.sombra.edu.library.demo.dto.BookAuthorDto;
import com.sombra.edu.library.demo.entity.BookAuthor;
import com.sombra.edu.library.demo.exception.ResourceNotFoundException;
import com.sombra.edu.library.demo.repository.AuthorRepository;
import com.sombra.edu.library.demo.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookAuthorConverterImpl implements BookAuthorConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public BookAuthor convertToEntity(BookAuthorDto bookAuthorDto) {
        BookAuthor bookAuthor = modelMapper.map(bookAuthorDto, BookAuthor.class);
        bookAuthor.setBook(bookRepository.findById(bookAuthorDto.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookAuthorDto.getBookId())));
        bookAuthor.setAuthor(authorRepository.findById(bookAuthorDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", bookAuthorDto.getAuthorId())));
        return bookAuthor;
    }

    @Override
    public BookAuthorDto convertToDto(BookAuthor bookAuthor) {
        BookAuthorDto bookAuthorDto = modelMapper.map(bookAuthor, BookAuthorDto.class);
        bookAuthorDto.setAuthorId(bookAuthor.getAuthor().getId());
        bookAuthorDto.setBookId(bookAuthor.getBook().getId());
        return bookAuthorDto;

    }
}
