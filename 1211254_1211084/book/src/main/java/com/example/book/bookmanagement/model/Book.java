package com.example.book.bookmanagement.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.StaleObjectStateException;
import com.example.book.authormanagement.model.Author;
import com.example.book.bookmanagement.services.UpdateBookRequest;
import com.example.book.exceptions.ConflictException;
import com.example.book.genremanagement.model.Genre;
import com.example.book.shared.model.EntityWithPhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Book", uniqueConstraints = {
        @UniqueConstraint(name = "uc_book_isbn", columnNames = {"ISBN"})
})
public class Book extends EntityWithPhoto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long pk;

    @Version
    @Getter
    private Long version;

    @Embedded
    Isbn isbn;

    @Getter
    @Embedded
    @NotNull
    Title title;

    @Getter
    @ManyToOne
    @NotNull
    Genre genre;

    @Getter
    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    @Embedded
    Description description;

    private void setTitle(String title) {this.title = new Title(title);}

    private void setIsbn(String isbn) {
        this.isbn = new Isbn(isbn);
    }

    private void setDescription(String description) {this.description = new Description(description); }

    private void setGenre(Genre genre) {this.genre = genre; }

    private void setAuthors(List<Author> authors) {this.authors = authors; }

    public String getDescription(){ return this.description.toString(); }

    public Book(String isbn, String title, String description, Genre genre, List<Author> authors, String photoURI) {
        setTitle(title);
        setIsbn(isbn);
        if(description != null)
            setDescription(description);
        if(genre==null)
            throw new IllegalArgumentException("Genre cannot be null");
        setGenre(genre);
        if(authors == null)
            throw new IllegalArgumentException("Author list is null");
        if(authors.isEmpty())
            throw new IllegalArgumentException("Author list is empty");

        setAuthors(authors);
        setPhotoInternal(photoURI);
    }

    protected Book() {
        // got ORM only
    }

    public void removePhoto(long desiredVersion) {
        if(desiredVersion != this.version) {
            throw new ConflictException("Provided version does not match latest version of this object");
        }

        setPhotoInternal(null);
    }

    public void applyPatch(final Long desiredVersion, UpdateBookRequest request) {
        if (!Objects.equals(this.version, desiredVersion))
            throw new StaleObjectStateException("Object was already modified by another user", this.pk);

        String title = request.getTitle();
        String description = request.getDescription();
        Genre genre = request.getGenreObj();
        List<Author> authors = request.getAuthorObjList();
        String photoURI = request.getPhotoURI();
        if(title != null) {
            setTitle(title);
        }

        if(description != null) {
            setDescription(description);
        }

        if(genre != null) {
            setGenre(genre);
        }

        if(authors != null) {
            setAuthors(authors);
        }

        if(photoURI != null)
            setPhotoInternal(photoURI);

    }

    public String getIsbn(){
        return this.isbn.toString();
    }
}
