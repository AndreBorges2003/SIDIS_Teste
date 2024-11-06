package com.example.book.bookmanagement.repositories;

import com.example.book.bookmanagement.model.Fine;

import java.util.Optional;

public interface FineRepository {

    Optional<Fine> findByLendingNumber(String lendingNumber);
    Iterable<Fine> findAll();

    Fine save(Fine fine);

}
