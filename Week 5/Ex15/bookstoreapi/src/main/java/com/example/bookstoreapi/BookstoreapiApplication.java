package com.example.bookstoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.bookstoreapi.model")
public class BookstoreapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookstoreapiApplication.class, args);
    }
}

