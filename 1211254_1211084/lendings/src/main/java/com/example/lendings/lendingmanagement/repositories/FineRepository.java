package com.example.lendings.lendingmanagement.repositories;

import com.example.lendings.lendingmanagement.model.Fine;

import java.util.Optional;

public interface FineRepository {

    Optional<Fine> findByLendingNumber(String lendingNumber);
    Iterable<Fine> findAll();

    Fine save(Fine fine);

}
