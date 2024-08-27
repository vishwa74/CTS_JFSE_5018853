package com.bookstore.dto;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.*;
import jakarta.validation.constraints.*;

@Data
public class BookDTO {
    @Nonnull
    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    @NotBlank
    private String author;

    @Min(0)
    private Double price;

    @NotBlank
    private String isbn;
}



