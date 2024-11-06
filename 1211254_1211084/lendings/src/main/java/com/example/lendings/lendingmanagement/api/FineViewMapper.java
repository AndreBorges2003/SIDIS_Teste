package com.example.lendings.lendingmanagement.api;

import com.example.lendings.lendingmanagement.model.Fine;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class FineViewMapper{

    public abstract FineView toFineView(Fine fine);

    public abstract Iterable<FineView> toFineView(Iterable<Fine> fines);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Fine partialUpdate(FineView fineView, @MappingTarget Fine fine);
}
