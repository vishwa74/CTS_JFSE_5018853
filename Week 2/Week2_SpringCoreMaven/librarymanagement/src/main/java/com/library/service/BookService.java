// Exercise 1: Configuring a Basic Spring Application
// Exercise 2: Implementing Dependency Injection
// Exercise 6: Configuring Beans with Annotations
// Exercise 7: Implementing Constructor and Setter Injection
package com.library.service;

import com.library.repository.BookRepository;
import com.library.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter method for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Business methods
    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
