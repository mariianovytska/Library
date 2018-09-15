package com.sombra.edu.library.demo.dto;

import com.sombra.edu.library.demo.entity.Author;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class AuthorDto extends BaseDto {

    private Long id;
    private String name;
    private Author.Gender gender;
    private Date born;
    private List<BookDto> books;
}
