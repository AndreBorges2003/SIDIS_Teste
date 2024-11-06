package com.example.book.genremanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.book.bookmanagement.services.GenreBookCountDTO;
import com.example.book.genremanagement.model.Genre;
import com.example.book.genremanagement.services.GenreLendingsDTO;
import com.example.book.genremanagement.services.GenreLendingsPerMonthDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    Iterable<Genre> findAll();
    Optional<Genre> findByString(String genreName);
    Genre save(Genre genre);
    Page<GenreBookCountDTO> findTop5GenreByBookCount(Pageable pageable);
    List<GenreLendingsDTO> getAverageLendingsInMonth(LocalDate month, com.example.book.shared.services.Page page);
    List<GenreLendingsPerMonthDTO> getLendingsPerMonthLastYearByGenre();
    List<GenreLendingsPerMonthDTO> getLendingsAverageDurationPerMonth(LocalDate startDate, LocalDate endDate);
    void delete(Genre genre);
}
