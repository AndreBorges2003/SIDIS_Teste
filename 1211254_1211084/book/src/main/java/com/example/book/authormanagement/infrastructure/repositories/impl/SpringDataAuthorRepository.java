package com.example.book.authormanagement.infrastructure.repositories.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.book.authormanagement.api.AuthorLendingView;
import com.example.book.authormanagement.model.Author;
import com.example.book.authormanagement.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataAuthorRepository extends AuthorRepository, CrudRepository<Author, Long> {
    @Override
    Optional<Author> findByAuthorNumber(Long authorNumber);

    @Override
    @Query("SELECT new com.example.book.authormanagement.api.AuthorLendingView(a.name.name, COUNT(l.pk)) " +
            "FROM Book b " +
            "JOIN b.authors a " +
            "JOIN Lending l ON l.book.pk = b.pk " +
            "GROUP BY a.name " +
            "ORDER BY COUNT(l) DESC")
    Page<AuthorLendingView> findTopAuthorByLendings(Pageable pageable);

    @Query("SELECT DISTINCT coAuthor FROM Book b " +
            "JOIN b.authors coAuthor " +
            "WHERE b IN (SELECT b FROM Book b JOIN b.authors a WHERE a.authorNumber = :authorNumber) " +
            "AND coAuthor.authorNumber <> :authorNumber")
    List<Author> findCoAuthorsByAuthorNumber(Long authorNumber);
}

