package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.assembler.BookResourceAssembler;
import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class CustomerController {

    private final BookRepository bookRepository;
    private final BookResourceAssembler bookResourceAssembler;

    public CustomerController(BookRepository bookRepository, BookResourceAssembler bookResourceAssembler) {
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
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookResourceAssembler.toModel(book);
    }

    public Class<?> getCustomerById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerById'");
    }

    public Class<?> getAllCustomers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCustomers'");
    }

    // Other CRUD operations
}
