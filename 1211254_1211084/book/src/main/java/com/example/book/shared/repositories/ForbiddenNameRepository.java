package com.example.book.shared.repositories;

import com.example.book.shared.model.ForbiddenName;

import java.util.List;
import java.util.Optional;

public interface ForbiddenNameRepository {
    Iterable<ForbiddenName> findAll();
    List<ForbiddenName> findByForbiddenNameIsContained(String pat);
    ForbiddenName save(ForbiddenName forbiddenName);

    Optional<ForbiddenName> findByForbiddenName(String forbiddenName);

    int deleteForbiddenName(String forbiddenName);

}
