package com.sombra.edu.library.demo.dto;

import com.sombra.edu.library.demo.entity.Book;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class BookDto extends BaseDto {

    private Long id;
    private String name;
    private Date published;
    private Book.Genre genre;
    private Integer rating;
    private List<AuthorDto> authors;
}
