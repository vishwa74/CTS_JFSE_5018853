package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.assembler.BookResourceAssembler;
import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookResourceAssembler bookResourceAssembler;

    public BookController(BookRepository bookRepository, BookResourceAssembler bookResourceAssembler) {
        this.bookRepository = bookRepository;
        this.bookResourceAssembler = bookResourceAssembler;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<EntityModel<Book>>> getAllBooks() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream()
                .map(bookResourceAssembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(books));
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<Book>> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return ResponseEntity.ok(bookResourceAssembler.toModel(book));
    }

    // Other CRUD operations
}
