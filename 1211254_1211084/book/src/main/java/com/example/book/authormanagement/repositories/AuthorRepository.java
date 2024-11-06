package com.example.book.authormanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.book.authormanagement.api.AuthorLendingView;
import com.example.book.authormanagement.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    Optional<Author> findByAuthorNumber(Long authorNumber);
    List<Author> searchByNameNameStartsWith(String name);
    List<Author> searchByNameName(String name);
    Author save(Author author);
    Iterable<Author> findAll();
    Page<AuthorLendingView> findTopAuthorByLendings (Pageable pageableRules);
    void delete(Author author);
    List<Author> findCoAuthorsByAuthorNumber(Long authorNumber);

}
