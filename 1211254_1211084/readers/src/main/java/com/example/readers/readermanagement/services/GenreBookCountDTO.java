package com.example.readers.readermanagement.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreBookCountDTO {
    private String genre;
    private long bookCount;
}
