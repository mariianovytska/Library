package com.sombra.edu.library.demo.service.impl;

import com.sombra.edu.library.demo.converter.AuthorConverter;
import com.sombra.edu.library.demo.dto.AuthorDto;
import com.sombra.edu.library.demo.entity.Author;
import com.sombra.edu.library.demo.exception.ResourceNotFoundException;
import com.sombra.edu.library.demo.repository.AuthorRepository;
import com.sombra.edu.library.demo.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorConverter authorConverter;

    @Override
    public AuthorDto getAuthor(Long authorId) {
        log.info(String.format("Getting author with id %d", authorId));
        return authorConverter.convertToDto(getAuthorByAuthorId(authorId));
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        log.info("Creating author: " + authorDto);
        return authorConverter.convertToDto(authorRepository.save(
                authorConverter.convertToEntity(authorDto)));
    }

    @Override
    public AuthorDto updateAuthor(Long authorId, AuthorDto authorDto) {
        Author author = getAuthorByAuthorId(authorId);
        author.setName(authorDto.getName());
        author.setGender(authorDto.getGender());
        author.setBorn(authorDto.getBorn());
        log.info("Updating author: " + author);
        return authorConverter.convertToDto(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long authorId) {
        log.info(String.format("Deleting author with id %d", authorId));
        authorRepository.delete(getAuthorByAuthorId(authorId));
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorConverter.convertToDto(authorRepository.findAll());
    }

    //Service method for task 2 - getting authors older then 55 years
    @Override
    public List<AuthorDto> getAuthorsOlderThen55() {
        log.info("Getting authors older then 55");
        return authorConverter.convertToDto(
                authorRepository.getAuthorsOlderThen55(Date.valueOf(LocalDate.now())));
    }

    //Service method for task 3 - getting authors with more then 1 book
    @Override
    public List<AuthorDto> getAuthorsHavingMore1Book() {
        log.info("Getting authors with more then 1 book");
        return authorConverter.convertToDto(
                authorRepository.getAuthorsHavingMore1Book());
    }

    //Service method for task 4 - getting authors with max number of books
    @Override
    public List<AuthorDto> getAuthorsHavingMaxBooks() {
        log.info("Getting authors with max number of books");
        return authorConverter.convertToDto(
                authorRepository.getAuthorsHavingMaxBooks());
    }

    private Author getAuthorByAuthorId(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() ->
                new ResourceNotFoundException("Author", "id", authorId));
    }
}
