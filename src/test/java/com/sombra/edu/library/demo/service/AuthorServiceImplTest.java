package com.sombra.edu.library.demo.service;

import com.sombra.edu.library.demo.converter.AuthorConverter;
import com.sombra.edu.library.demo.dto.AuthorDto;
import com.sombra.edu.library.demo.entity.Author;
import com.sombra.edu.library.demo.repository.AuthorRepository;
import com.sombra.edu.library.demo.service.impl.AuthorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private AuthorConverter authorConverter;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test()
    public void getAuthorTest() {
        Mockito.when(authorRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(authorInstance()));
        Mockito.when(authorRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(authorInstance()));
        Mockito.when(authorConverter.convertToDto(Mockito.any(Author.class))).thenReturn(authorDtoInstance());
        AuthorDto authorDto = authorService.getAuthor(1L);
        assertEquals(authorDto.getName(), authorInstance().getName());
    }

    @Test
    public void createAuthorTest() {
        Author author = authorInstance();
        Mockito.when(authorRepository.save(Mockito.any())).thenReturn(author);
        Mockito.when(authorConverter.convertToDto(Mockito.any(Author.class))).thenReturn(authorDtoInstance());
        AuthorDto authorDto = authorService.createAuthor(authorDtoInstance());
        assertEquals(author.getName(), authorDto.getName());
    }

    @Test
    public void updateAuthorTest() {
        Mockito.when(authorRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(authorInstance()));
        Author oldAuthor = authorInstance();
        AuthorDto oldAuthorDto = authorDtoInstance();
        oldAuthorDto.setName("456");
        oldAuthorDto.setName(oldAuthor.getName());
        Mockito.when(authorRepository.save(Mockito.any())).thenReturn(oldAuthor);
        Mockito.when(authorConverter.convertToDto(oldAuthor)).thenReturn(oldAuthorDto);
        AuthorDto authorDto = authorService.updateAuthor(1L, authorDtoInstance());
        assertEquals(oldAuthor.getName(), authorDto.getName());
    }

    @Test
    public void getAllAuthorsTest() {
        Mockito.when(authorRepository.findAll()).thenReturn(authorsInstance());
        Mockito.when(authorConverter.convertToDto(Mockito.anyList())).thenReturn(authorDtosInstance());
        List<AuthorDto> authorDtoList = authorService.getAllAuthors();
        assertEquals(authorDtoList.get(0).getName(), authorDtosInstance().get(0).getName());
    }

    private List<Author> authorsInstance() {
        List<Author> authors = new ArrayList<>();
        authors.add(authorInstance());
        return authors;
    }

    private List<AuthorDto> authorDtosInstance() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        authorDtos.add(authorDtoInstance());
        return authorDtos;
    }

    private Author authorInstance() {
        Author author = new Author();
        author.setName("123");
        return author;
    }

    private AuthorDto authorDtoInstance() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName("123");
        return authorDto;
    }
}
