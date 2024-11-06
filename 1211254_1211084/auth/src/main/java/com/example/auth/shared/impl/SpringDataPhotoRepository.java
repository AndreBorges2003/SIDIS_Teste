package com.example.auth.shared.impl;

import com.example.auth.shared.model.Photo;
import com.example.auth.shared.repositories.PhotoRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SpringDataPhotoRepository extends PhotoRepository, CrudRepository<Photo, Long> {
    /*@Override
    @Query("SELECT p " +
            "FROM Photo p " +
            "WHERE p.pk = :photo_id")
    Optional<Photo> findById(@Param("photo_id") long id);*/
    @Override
    @Modifying
    @Transactional
    @Query("DELETE " +
            "FROM Photo p " +
            "WHERE p.photoFile = :photoFile")
    void deleteByPhotoFile(String photoFile);
}
