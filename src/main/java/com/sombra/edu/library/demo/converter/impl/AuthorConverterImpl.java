package com.sombra.edu.library.demo.converter.impl;

import com.sombra.edu.library.demo.converter.AuthorConverter;
import com.sombra.edu.library.demo.converter.BookConverter;
import com.sombra.edu.library.demo.dto.AuthorDto;
import com.sombra.edu.library.demo.dto.BookDto;
import com.sombra.edu.library.demo.entity.Author;
import com.sombra.edu.library.demo.entity.BookAuthor;
import com.sombra.edu.library.demo.repository.BookAuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorConverterImpl implements AuthorConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Override
    public Author convertToEntity(AuthorDto authorDto) {
        return modelMapper.map(authorDto, Author.class);
    }

    @Override
    public AuthorDto convertToDto(Author author) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAllByAuthorId(author.getId());
        List<BookDto> bookDtoList = new ArrayList<>();
        for(BookAuthor bookAuthor: bookAuthors){
            BookDto bookDto = new BookDto();
            bookDto.setId(bookAuthor.getBook().getId());
            bookDto.setName(bookAuthor.getBook().getName());
            bookDto.setPublished(bookAuthor.getBook().getPublished());
            bookDto.setGenre(bookAuthor.getBook().getGenre());
            bookDto.setRating(bookAuthor.getBook().getRating());
            bookDtoList.add(bookDto);
        }
        AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
        authorDto.setBooks(bookDtoList);
        return authorDto;
    }
}
