package com.example.readers.readermanagement.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Reader with lending count")
public class ReaderCountView {
    @NotNull
    private ReaderView readerView;

    private Long lendingCount;
}
