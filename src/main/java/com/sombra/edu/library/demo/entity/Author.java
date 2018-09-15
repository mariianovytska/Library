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
@Table(name = "authors")
public class Author extends BaseEntity<Long>{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "born")
    private Date born;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    public enum Gender{
        male,
        female
    }
}
