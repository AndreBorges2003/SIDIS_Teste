package com.example.lendings.lendingmanagement.repositories;

import com.example.lendings.lendingmanagement.model.Lending;
import com.example.lendings.shared.services.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface LendingRepository {
    Optional<Lending> findByLendingNumber(String lendingNumber);
    List<Lending> listByReaderNumberAndIsbn(String readerNumber, String isbn);
    int getCountFromCurrentYear();
    List<Lending> listOutstandingByReaderNumber(String readerNumber);
    Double getAverageDuration();
    Double getAvgLendingDurationByIsbn(String isbn);


    List<Lending> getOverdue(Page page);
    List<Lending> searchLendings(Page page, String readerNumber, String isbn, Boolean returned, LocalDate startDate, LocalDate endDate);

    Lending save(Lending lending);

    void delete(Lending lending);

}
