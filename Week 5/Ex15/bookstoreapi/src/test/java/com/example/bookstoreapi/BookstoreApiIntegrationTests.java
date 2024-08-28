package com.example.bookstoreapi;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookstoreApiIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setupDatabase() {
        bookRepository.deleteAll();  // Clean up the database before each test
        Book book = new Book();
        book.setTitle("Existing Book Title");
        book.setAuthor("Author");
        book.setPrice(29.99);
        bookRepository.save(book);  // Add a test book to the database
    }
    @Test
    public void shouldReturnListOfBooks() throws Exception {
        mockMvc.perform(get("/books"))
               .andExpect(status().isOk())  // Verify that the status code is 200 OK
               .andExpect(jsonPath("$", hasSize(greaterThan(0))))  // Ensure the response contains an array with at least one book
               .andExpect(jsonPath("$[0].title", is("Existing Book Title")));  // Check the title of the first book
    }

    @Test
    public void shouldCreateNewBook() throws Exception {
        Book newBook = new Book();
        newBook.setTitle("New Book Title");
        newBook.setAuthor("Author");
        newBook.setPrice(19.99);

        mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(newBook)))  // Convert the Book object to a JSON string
            .andExpect(status().isCreated())  // Verify that the status code is 201 Created
            .andExpect(header().string("Location", containsString("/books/")));  // Check if the Location header is set correctly
    }


    @Test
    public void shouldDeleteBook() throws Exception {
        Long existingBookId = bookRepository.findAll().get(0).getId();  // Get the ID of the test book
        
        mockMvc.perform(delete("/books/{id}", existingBookId))
               .andExpect(status().isNoContent());  // Verify that the status code is 204 No Content

        assertFalse(bookRepository.findById(existingBookId).isPresent());  // Check that the book was deleted from the database
    }
}
