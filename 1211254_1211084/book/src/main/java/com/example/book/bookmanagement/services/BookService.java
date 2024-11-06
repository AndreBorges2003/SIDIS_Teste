package com.example.book.bookmanagement.services;


import com.example.book.bookmanagement.model.Book;
import com.example.book.shared.services.Page;

import java.util.List;

/**
 *
 */
public interface BookService {
    Book create(CreateBookRequest request, String isbn);
    Book save(Book book);
    Book findByIsbn(String isbn);
    Book update(UpdateBookRequest request, String currentVersion);
    List<Book> findByGenre(String genre);
    List<Book> findByTitle(String title);
    List<Book> findByAuthorName(String authorName);
    List<BookCountDTO> findTop5BooksLent();
    Book removeBookPhoto(String isbn, long desiredVersion);
    //List<Book> getBooksSuggestionsForReader(String readerNumber);
    List<Book> searchBooks(Page page, SearchBooksQuery query);
}
