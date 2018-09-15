package com.sombra.edu.library.demo.service;

import com.sombra.edu.library.demo.converter.BookAuthorConverter;
import com.sombra.edu.library.demo.dto.BookAuthorDto;
import com.sombra.edu.library.demo.entity.Author;
import com.sombra.edu.library.demo.entity.Book;
import com.sombra.edu.library.demo.entity.BookAuthor;
import com.sombra.edu.library.demo.repository.BookAuthorRepository;
import com.sombra.edu.library.demo.service.impl.BookAuthorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BookAuthorServiceImplTest {

    @Mock
    private BookAuthorRepository bookAuthorRepository;

    @Mock
    private BookAuthorConverter bookAuthorConverter;

    @InjectMocks
    private BookAuthorServiceImpl bookAuthorService;

    @Test()
    public void getBookAuthorTest() {
        Mockito.when(bookAuthorRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(bookAuthorInstance()));
        Mockito.when(bookAuthorRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(bookAuthorInstance()));
        Mockito.when(bookAuthorConverter.convertToDto(Mockito.any(BookAuthor.class))).thenReturn(bookAuthorDtoInstance());
        BookAuthorDto bookAuthorDto = bookAuthorService.getBookAuthor(1L);
        assertEquals(bookAuthorDto.getAuthorId(), bookAuthorInstance().getAuthor().getId());
    }

    @Test
    public void createBookAuthorTest() {
        BookAuthor bookAuthor = bookAuthorInstance();
        Mockito.when(bookAuthorRepository.save(Mockito.any())).thenReturn(bookAuthor);
        Mockito.when(bookAuthorConverter.convertToDto(Mockito.any(BookAuthor.class))).thenReturn(bookAuthorDtoInstance());
        BookAuthorDto bookAuthorDto = bookAuthorService.createBookAuthor(bookAuthorDtoInstance());
        assertEquals(bookAuthor.getAuthor().getId(), bookAuthorDto.getAuthorId());
    }

    @Test
    public void updateBookAuthorTest() {
        Mockito.when(bookAuthorRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(bookAuthorInstance()));
        BookAuthor oldBookAuthor = bookAuthorInstance();
        BookAuthorDto oldBookAuthorDto = bookAuthorDtoInstance();
        oldBookAuthor.setAuthor(authorInstance());
        oldBookAuthorDto.setAuthorId(oldBookAuthor.getAuthor().getId());
        Mockito.when(bookAuthorRepository.save(Mockito.any())).thenReturn(oldBookAuthor);
        Mockito.when(bookAuthorConverter.convertToDto(oldBookAuthor)).thenReturn(oldBookAuthorDto);
        BookAuthorDto bookAuthorDto = bookAuthorService.updateBookAuthor(1L, bookAuthorDtoInstance());
        assertEquals(oldBookAuthor.getAuthor().getId(), bookAuthorDto.getAuthorId());
    }

    private BookAuthor bookAuthorInstance() {
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setBook(bookInstance());
        bookAuthor.setAuthor(authorInstance());
        return bookAuthor;
    }

    private BookAuthorDto bookAuthorDtoInstance() {
        BookAuthorDto bookAuthorDto = new BookAuthorDto();
        bookAuthorDto.setAuthorId(1L);
        bookAuthorDto.setBookId(1L);
        return bookAuthorDto;
    }

    private Author authorInstance() {
        Author author = new Author();
        author.setId(1L);
        return author;
    }

    private Book bookInstance() {
        Book book = new Book();
        book.setId(1L);
        return book;
    }

}
