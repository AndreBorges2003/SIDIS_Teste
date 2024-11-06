package com.example.readers.readermanagement.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.readers.readermanagement.    model.Genre;
import com.example.readers.readermanagement.model.ReaderDetails;
import com.example.readers.readermanagement.model.Reader;
//import pt.psoft.g1.psoftg1.usermanagement.services.UserService;

import java.util.List;

/**
 * Brief guide:
 * <a href="https://www.baeldung.com/mapstruct">https://www.baeldung.com/mapstruct</a>
 * */
@Mapper(componentModel = "spring", uses = {ReaderService.class/*, UserService.class*/})
public abstract class ReaderMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "name", source = "fullName")
    public abstract Reader createReader(CreateReaderRequest request);

    @Mapping(target = "photo", source = "photoURI")
    @Mapping(target = "interestList", source = "interestList")
    public abstract ReaderDetails createReaderDetails(int readerNumber, Reader reader, CreateReaderRequest request, String photoURI, List<Genre> interestList);
}
