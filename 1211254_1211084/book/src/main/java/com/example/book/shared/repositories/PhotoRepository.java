package com.example.book.shared.repositories;

import org.springframework.data.repository.query.Param;
import com.example.book.shared.model.Photo;
import java.util.Optional;

public interface PhotoRepository {
    //Optional<Photo> findById(long id);

    //Photo save(Photo photo);
    void deleteByPhotoFile(String photoFile);
}
