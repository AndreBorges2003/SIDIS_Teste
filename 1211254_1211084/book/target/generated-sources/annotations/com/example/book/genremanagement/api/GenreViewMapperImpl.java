package com.example.book.genremanagement.api;

import com.example.book.bookmanagement.services.GenreBookCountDTO;
import com.example.book.genremanagement.model.Genre;
import com.example.book.genremanagement.services.GenreLendingsDTO;
import com.example.book.genremanagement.services.GenreLendingsPerMonthDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T16:46:22+0000",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class GenreViewMapperImpl extends GenreViewMapper {

    @Override
    public GenreView toGenreView(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreView genreView = new GenreView();

        genreView.setGenre( map( genre.getGenre() ) );

        return genreView;
    }

    @Override
    public GenreView mapStringToGenreView(String genre) {
        if ( genre == null ) {
            return null;
        }

        GenreView genreView = new GenreView();

        genreView.setGenre( map( genre ) );

        return genreView;
    }

    @Override
    public GenreBookCountView toGenreBookCountView(GenreBookCountDTO genreBookCountView) {
        if ( genreBookCountView == null ) {
            return null;
        }

        GenreBookCountView genreBookCountView1 = new GenreBookCountView();

        genreBookCountView1.setGenreView( mapStringToGenreView( genreBookCountView.getGenre() ) );
        genreBookCountView1.setBookCount( genreBookCountView.getBookCount() );

        return genreBookCountView1;
    }

    @Override
    public List<GenreBookCountView> toGenreBookCountView(List<GenreBookCountDTO> genreBookCountView) {
        if ( genreBookCountView == null ) {
            return null;
        }

        List<GenreBookCountView> list = new ArrayList<GenreBookCountView>( genreBookCountView.size() );
        for ( GenreBookCountDTO genreBookCountDTO : genreBookCountView ) {
            list.add( toGenreBookCountView( genreBookCountDTO ) );
        }

        return list;
    }

    @Override
    public GenreLendingsView toGenreAvgLendingsView(GenreLendingsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GenreLendingsView genreLendingsView = new GenreLendingsView();

        genreLendingsView.setGenre( map( dto.getGenre() ) );
        genreLendingsView.setValue( map( dto.getValue() ) );

        return genreLendingsView;
    }

    @Override
    public List<GenreLendingsView> toGenreAvgLendingsView(List<GenreLendingsDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<GenreLendingsView> list = new ArrayList<GenreLendingsView>( dtos.size() );
        for ( GenreLendingsDTO genreLendingsDTO : dtos ) {
            list.add( toGenreAvgLendingsView( genreLendingsDTO ) );
        }

        return list;
    }

    @Override
    public GenreLendingsCountPerMonthView toGenreLendingsCountPerMonthView(GenreLendingsPerMonthDTO dto) {
        if ( dto == null ) {
            return null;
        }

        List<GenreLendingsView> lendingsCount = null;
        Integer year = null;
        Integer month = null;

        lendingsCount = toGenreAvgLendingsView( dto.getValues() );
        year = dto.getYear();
        month = dto.getMonth();

        GenreLendingsCountPerMonthView genreLendingsCountPerMonthView = new GenreLendingsCountPerMonthView( year, month, lendingsCount );

        return genreLendingsCountPerMonthView;
    }

    @Override
    public List<GenreLendingsCountPerMonthView> toGenreLendingsCountPerMonthView(List<GenreLendingsPerMonthDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<GenreLendingsCountPerMonthView> list = new ArrayList<GenreLendingsCountPerMonthView>( dtos.size() );
        for ( GenreLendingsPerMonthDTO genreLendingsPerMonthDTO : dtos ) {
            list.add( toGenreLendingsCountPerMonthView( genreLendingsPerMonthDTO ) );
        }

        return list;
    }

    @Override
    public GenreLendingsAvgPerMonthView toGenreLendingsAveragePerMonthView(GenreLendingsPerMonthDTO dto) {
        if ( dto == null ) {
            return null;
        }

        List<GenreLendingsView> durationAverages = null;
        Integer year = null;
        Integer month = null;

        durationAverages = toGenreAvgLendingsView( dto.getValues() );
        year = dto.getYear();
        month = dto.getMonth();

        GenreLendingsAvgPerMonthView genreLendingsAvgPerMonthView = new GenreLendingsAvgPerMonthView( year, month, durationAverages );

        return genreLendingsAvgPerMonthView;
    }

    @Override
    public List<GenreLendingsAvgPerMonthView> toGenreLendingsAveragePerMonthView(List<GenreLendingsPerMonthDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<GenreLendingsAvgPerMonthView> list = new ArrayList<GenreLendingsAvgPerMonthView>( dtos.size() );
        for ( GenreLendingsPerMonthDTO genreLendingsPerMonthDTO : dtos ) {
            list.add( toGenreLendingsAveragePerMonthView( genreLendingsPerMonthDTO ) );
        }

        return list;
    }
}
