package com.sombra.edu.library.demo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseEntity<I> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private I id;
}
