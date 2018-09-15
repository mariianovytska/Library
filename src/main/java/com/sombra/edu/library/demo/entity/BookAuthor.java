package com.sombra.edu.library.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author_book")
public class BookAuthor extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "book_id",  nullable = false)
    Book book;

    @ManyToOne
    @JoinColumn(name = "author_id",  nullable = false)
    Author author;
}
