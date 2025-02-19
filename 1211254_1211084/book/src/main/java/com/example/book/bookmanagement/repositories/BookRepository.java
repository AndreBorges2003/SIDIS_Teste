package com.example.book.bookmanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import com.example.book.bookmanagement.model.Book;
import com.example.book.bookmanagement.services.BookCountDTO;
import com.example.book.bookmanagement.services.SearchBooksQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 *
 */
public interface BookRepository {


    List<Book> findByGenre(@Param("genre") String genre);
    List<Book> findByTitle(@Param("title") String title);
    List<Book> findByAuthorName(@Param("authorName") String authorName);
    Optional<Book> findByIsbn(@Param("isbn") String isbn);
    Page<BookCountDTO> findTop5BooksLent(@Param("oneYearAgo") LocalDate oneYearAgo, Pageable pageable);
    List<Book> findBooksByAuthorNumber(Long authorNumber);

    List<Book> searchBooks(com.example.book.shared.services.Page page, SearchBooksQuery query);

    Book save(Book book);
    void delete(Book book);
}
