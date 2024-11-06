package com.example.readers.readermanagement.services;

import com.example.readers.readermanagement.model.ReaderDetails;
import com.example.readers.shared.services.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface ReaderService {
    ReaderDetails create(CreateReaderRequest request, String photoURI);
    ReaderDetails update(Long id, UpdateReaderRequest request, long desireVersion, String photoURI);
    Optional<ReaderDetails> findByUsername(final String username);
    Optional<ReaderDetails> findByReaderNumber(String readerNumber);
    List<ReaderDetails> findByPhoneNumber(String phoneNumber);
    Iterable<ReaderDetails> findAll();
    List<ReaderDetails> findTopReaders(int minTop);
    List<ReaderBookCountDTO> findTopByGenre(String genre, LocalDate startDate, LocalDate endDate);
    //Optional<Reader> update(UpdateReaderRequest request) throws Exception;
    Optional<ReaderDetails> removeReaderPhoto(String readerNumber, long desiredVersion);
    List<ReaderDetails> searchReaders(Page page, SearchReadersQuery query);
}
