package com.example.lendings.lendingmanagement.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchBooksQuery {
    private String title;
    private String genre;
    private String authorName;
}
