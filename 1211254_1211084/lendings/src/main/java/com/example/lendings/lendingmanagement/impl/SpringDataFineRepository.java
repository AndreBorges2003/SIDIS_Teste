package com.example.lendings.lendingmanagement.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.lendings.lendingmanagement.model.Fine;
import com.example.lendings.lendingmanagement.repositories.FineRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataFineRepository extends FineRepository, CrudRepository<Fine, Long> {

    @Override
    @Query("SELECT f " +
            "FROM Fine f " +
            "JOIN Lending l ON f.lending.pk = l.pk " +
            "WHERE l.lendingNumber.lendingNumber = :lendingNumber")
    Optional<Fine> findByLendingNumber(String lendingNumber);

}
