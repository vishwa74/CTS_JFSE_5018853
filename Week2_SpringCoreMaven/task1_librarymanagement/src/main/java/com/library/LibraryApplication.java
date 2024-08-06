// src/main/java/com/library/LibraryApplication.java
package com.library;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        try {
            BookService bookService = (BookService) context.getBean("bookService");
            bookService.addBook("Spring in Action");
        } finally {
            context.close();
        }
    }
}
