package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.assembler.BookResourceAssembler;
import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookResourceAssembler bookResourceAssembler;

    public BookController(BookRepository bookRepository, BookResourceAssembler bookResourceAssembler) {
        this.bookRepository = bookRepository;
        this.bookResourceAssembler = bookResourceAssembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Book>> getAllBooks() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream()
                .map(bookResourceAssembler::toModel)
                .toList();
        return CollectionModel.of(books);
    }

    @GetMapping("/{id}")
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(bookResourceAssembler::toModel)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    // Other CRUD operations
}
