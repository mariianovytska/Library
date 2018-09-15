package com.sombra.edu.library.demo.converter.impl;

import com.sombra.edu.library.demo.converter.AuthorConverter;
import com.sombra.edu.library.demo.converter.BookAuthorConverter;
import com.sombra.edu.library.demo.converter.BookConverter;
import com.sombra.edu.library.demo.dto.AuthorDto;
import com.sombra.edu.library.demo.dto.BookDto;
import com.sombra.edu.library.demo.entity.Book;
import com.sombra.edu.library.demo.entity.BookAuthor;
import com.sombra.edu.library.demo.repository.BookAuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookConverterImpl implements BookConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Override
    public Book convertToEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }

    @Override
    public BookDto convertToDto(Book book) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAllByBookId(book.getId());
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for(BookAuthor bookAuthor: bookAuthors){
            AuthorDto authorDto = new AuthorDto();
            authorDto.setId(bookAuthor.getAuthor().getId());
            authorDto.setName(bookAuthor.getAuthor().getName());
            authorDto.setGender(bookAuthor.getAuthor().getGender());
            authorDto.setBorn(bookAuthor.getAuthor().getBorn());
            authorDtoList.add(authorDto);
        }
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        bookDto.setAuthors(authorDtoList);
        return bookDto;

    }
}
