package com.sombra.edu.library.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity<Long>{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "published")
    private Date published;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    public enum Genre{
        fantasy,
        education,
        technical,
        novel,
        historical_novel,
        crime
    }
}
