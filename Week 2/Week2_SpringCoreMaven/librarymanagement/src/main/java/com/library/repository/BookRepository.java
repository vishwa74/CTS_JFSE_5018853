// Exercise 1: Configuring a Basic Spring Application
// Exercise 6: Configuring Beans with Annotations
package com.library.repository;

import com.library.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void save(Book book) {
        // Save the book to the database
        System.out.println("Saving book: " + book);
    }
}
