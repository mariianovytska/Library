package com.sombra.edu.library.demo.service;

import com.sombra.edu.library.demo.dto.AuthorDto;

import java.sql.Date;
import java.util.List;

public interface AuthorService {

    AuthorDto getAuthor(Long authorId);

    AuthorDto createAuthor(AuthorDto authorDto);

    AuthorDto updateAuthor(Long authorId, AuthorDto authorDto);

    void deleteAuthor(Long authorId);

    List<AuthorDto> getAllAuthors();

    List<AuthorDto> getAuthorsOlderThen55();

    List<AuthorDto> getAuthorsHavingMore1Book();

    List<AuthorDto> getAuthorsHavingMaxBooks();
}
