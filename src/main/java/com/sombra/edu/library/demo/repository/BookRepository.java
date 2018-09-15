package com.sombra.edu.library.demo.repository;

import com.sombra.edu.library.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long bookId);

    @Override
    List<Book> findAll();

    @Query(value = "SELECT count(books.id) from books where genre = :genreE ;", nativeQuery = true)
    Integer countAllByGenre(@Param("genreE") String genreE);
}
