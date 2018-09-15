package com.sombra.edu.library.demo.dto;

import lombok.Data;

@Data
public class BookAuthorDto extends BaseDto {

    private Long id;
    private Long bookId;
    private Long authorId;
}
