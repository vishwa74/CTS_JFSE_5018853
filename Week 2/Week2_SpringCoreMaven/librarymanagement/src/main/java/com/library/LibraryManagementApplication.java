// Exercise 1: Configuring a Basic Spring Application
// Exercise 2: Implementing Dependency Injection
// Exercise 3: Implementing Logging with Spring AOP
// Exercise 6: Configuring Beans with Annotations
// Exercise 7: Implementing Constructor and Setter Injection
// Exercise 8: Implementing Basic AOP with Spring
package com.library;

import com.library.model.Book;
import com.library.service.BookService;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Initialize Spring application context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Creating a book and adding it to the service
        Book book = new Book("12345", "Spring in Action", "Craig Walls");
        bookService.addBook(book);

        System.out.println("Book added successfully");

        // Close the context to release resources
        context.close();
    }
}
