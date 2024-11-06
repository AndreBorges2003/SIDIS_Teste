package com.example.book.authormanagement.services;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthorRequest {
    @Size(max = 4096)
    private String bio;

    @Size(max = 150)
    private String name;

    @Nullable
    @Getter
    @Setter
    private MultipartFile photo;

    @Nullable
    @Getter
    @Setter
    private String photoURI;
}
