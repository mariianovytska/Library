package com.sombra.edu.library.demo.repository;

import com.sombra.edu.library.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Override
    Optional<Author> findById(Long authorId);

    @Query(value = "SELECT * from authors having TIMESTAMPDIFF(YEAR, born, :today) > 55 order by born asc;", nativeQuery = true)
    List<Author> getAuthorsOlderThen55(@Param("today") Date today);

    @Query(value = "select authors.id, authors.name, authors.gender, authors.born " +
            "from authors inner join author_book on authors.id = author_book.author_id " +
            "group by authors.id having count(author_book.id) >1;", nativeQuery = true)
    List<Author> getAuthorsHavingMore1Book();

    @Query(value = "select authors.id, authors.name, authors.gender, authors.born " +
            "from authors inner join author_book on authors.id = author_book.author_id " +
            "group by authors.id having count(author_book.book_id) = (" +
            "select max(res.total) as total from (" +
            "select count(author_book.book_id) as total " +
            "from authors inner join author_book on authors.id = author_book.author_id group by authors.id) res);", nativeQuery = true)
    List<Author> getAuthorsHavingMaxBooks();

}
