package com.example.lendings.lendingmanagement.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.lendings.lendingmanagement.model.ReaderDetails;


@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderBookCountDTO {
    private ReaderDetails readerDetails;
    private long lendingCount;
}
