package com.example.book.genremanagement.api;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.book.bookmanagement.services.GenreBookCountDTO;
import com.example.book.genremanagement.model.Genre;
import com.example.book.genremanagement.services.GenreLendingsDTO;
import com.example.book.genremanagement.services.GenreLendingsPerMonthDTO;
import com.example.book.shared.api.MapperInterface;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GenreViewMapper extends MapperInterface{

    @Mapping(target = "genre", source = "genre")
    public abstract GenreView toGenreView(Genre genre);

    public abstract GenreView mapStringToGenreView(String genre);

    @Mapping(target = "genreView", source = "genre")
    public abstract GenreBookCountView toGenreBookCountView(GenreBookCountDTO genreBookCountView);
    public abstract List<GenreBookCountView> toGenreBookCountView(List<GenreBookCountDTO> genreBookCountView);

    public abstract GenreLendingsView toGenreAvgLendingsView(GenreLendingsDTO dto);
    public abstract List<GenreLendingsView> toGenreAvgLendingsView(List<GenreLendingsDTO> dtos);

    @Mapping(target = "lendingsCount", source = "values")
    public abstract GenreLendingsCountPerMonthView toGenreLendingsCountPerMonthView(GenreLendingsPerMonthDTO dto);
    public abstract List<GenreLendingsCountPerMonthView> toGenreLendingsCountPerMonthView(List<GenreLendingsPerMonthDTO> dtos);


    @Mapping(target = "durationAverages", source = "values")
    public abstract GenreLendingsAvgPerMonthView toGenreLendingsAveragePerMonthView(GenreLendingsPerMonthDTO dto);
    public abstract List<GenreLendingsAvgPerMonthView> toGenreLendingsAveragePerMonthView(List<GenreLendingsPerMonthDTO> dtos);


}
