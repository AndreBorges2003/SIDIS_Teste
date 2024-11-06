package com.example.book.authormanagement.services;

import com.example.book.authormanagement.model.Author;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T16:46:22+0000",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl extends AuthorMapper {

    @Override
    public Author create(CreateAuthorRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        String bio = null;
        String photoURI = null;

        name = map( request.getName() );
        bio = map( request.getBio() );
        photoURI = map( request.getPhotoURI() );

        Author author = new Author( name, bio, photoURI );

        author.setPhoto( map( request.getPhotoURI() ) );

        return author;
    }

    @Override
    public void update(UpdateAuthorRequest request, Author author) {
        if ( request == null ) {
            return;
        }

        author.setPhoto( map( request.getPhoto() ) );
        author.setName( map( request.getName() ) );
        author.setBio( map( request.getBio() ) );
    }
}
