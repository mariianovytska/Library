package com.sombra.edu.library.demo.repository;

import com.sombra.edu.library.demo.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

    @Override
    Optional<BookAuthor> findById(Long bookAuthorId);

    List<BookAuthor> findAllByAuthorId (Long authorId);

    List<BookAuthor> findAllByBookId (Long bookId);

}
