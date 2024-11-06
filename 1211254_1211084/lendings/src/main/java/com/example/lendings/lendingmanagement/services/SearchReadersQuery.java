package com.example.lendings.lendingmanagement.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchReadersQuery {
    private String name;
    private String phoneNumber;
    private String email;
}
