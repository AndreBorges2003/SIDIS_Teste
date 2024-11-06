package com.example.readers.readermanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.readers.readermanagement.services.GenreBookCountDTO;
import com.example.readers.readermanagement.model.Genre;
import com.example.readers.readermanagement.services.GenreLendingsDTO;
import com.example.readers.readermanagement.services.GenreLendingsPerMonthDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    Iterable<Genre> findAll();
    Optional<Genre> findByString(String genreName);
    Genre save(Genre genre);
    Page<GenreBookCountDTO> findTop5GenreByBookCount(Pageable pageable);
    List<GenreLendingsDTO> getAverageLendingsInMonth(LocalDate month, com.example.readers.shared.services.Page page);
    List<GenreLendingsPerMonthDTO> getLendingsPerMonthLastYearByGenre();
    List<GenreLendingsPerMonthDTO> getLendingsAverageDurationPerMonth(LocalDate startDate, LocalDate endDate);
    void delete(Genre genre);
}
