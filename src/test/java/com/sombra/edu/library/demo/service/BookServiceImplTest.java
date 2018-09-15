package com.sombra.edu.library.demo.service;

import com.sombra.edu.library.demo.converter.BookConverter;
import com.sombra.edu.library.demo.dto.BookDto;
import com.sombra.edu.library.demo.entity.Book;
import com.sombra.edu.library.demo.repository.BookRepository;
import com.sombra.edu.library.demo.service.impl.BookServiceImpl;
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
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookConverter bookConverter;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test()
    public void getBookTest() {
        Mockito.when(bookRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(bookInstance()));
        Mockito.when(bookConverter.convertToDto(Mockito.any(Book.class))).thenReturn(bookDtoInstance());
        BookDto bookDto = bookService.getBook(1L);
        assertEquals(bookDto.getName(), bookInstance().getName());
    }

    @Test
    public void createBookTest() {
        Book book = bookInstance();
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
        Mockito.when(bookConverter.convertToDto(Mockito.any(Book.class))).thenReturn(bookDtoInstance());
        BookDto bookDto = bookService.createBook(bookDtoInstance());
        assertEquals(book.getName(), bookDto.getName());
    }

    @Test
    public void updateBookTest() {
        Mockito.when(bookRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(bookInstance()));
        Book oldBook = bookInstance();
        BookDto oldBookDto = bookDtoInstance();
        oldBook.setName("456");
        oldBookDto.setName(oldBook.getName());
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(oldBook);
        Mockito.when(bookConverter.convertToDto(oldBook)).thenReturn(oldBookDto);
        BookDto newBookDto = bookService.updateBook(1L, oldBookDto);
        assertEquals(oldBook.getName(), newBookDto.getName());
    }

    @Test
    public void getAllBooksTest() {
        Mockito.when(bookRepository.findAll()).thenReturn(booksInstance());
        Mockito.when(bookConverter.convertToDto(Mockito.anyList())).thenReturn(bookDtosInstance());
        List<BookDto> bookDtoList = bookService.getAllBooks();
        assertEquals(bookDtoList.get(0).getName(), bookDtosInstance().get(0).getName());
    }

    private List<Book> booksInstance() {
        List<Book> books = new ArrayList<>();
        books.add(bookInstance());
        return books;
    }

    private List<BookDto> bookDtosInstance() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(bookDtoInstance());
        return bookDtos;
    }

    private Book bookInstance() {
        Book book = new Book();
        book.setName("123");
        return book;
    }

    private BookDto bookDtoInstance() {
        BookDto bookDto = new BookDto();
        bookDto.setName("123");
        return bookDto;
    }
}
