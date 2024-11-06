package com.example.book.genremanagement.services;

import com.example.book.bookmanagement.services.GenreBookCountDTO;
import com.example.book.genremanagement.model.Genre;
import com.example.book.shared.services.Page;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Iterable<Genre> findAll();
    Genre save(Genre genre);
    Optional<Genre> findByString(String name);
    List<GenreBookCountDTO> findTopGenreByBooks();
    List<GenreLendingsDTO> getAverageLendings(GetAverageLendingsQuery query, Page page);
    List<GenreLendingsPerMonthDTO> getLendingsPerMonthLastYearByGenre();
    List<GenreLendingsPerMonthDTO> getLendingsAverageDurationPerMonth(String startDate, String endDate);
}
