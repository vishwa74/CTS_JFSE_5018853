package com.bookstore.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstore.model.Customer;
import com.bookstore.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookstore.*;
import com.bookstore.dto.CustomerDTO;
import com.bookstore.mapper.CustomerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(); // In-memory storage for simplicity
    @Autowired
    private CustomerRepository customerRepository;


    // Endpoint to create a new customer by accepting a JSON request body
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(CustomerMapper.INSTANCE.customerToCustomerDTO(savedCustomer), HttpStatus.CREATED);
    }
    // Endpoint to process form data for customer registrations
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam String name,
                                                     @RequestParam String email) {
        Customer customer = new Customer(); // Create and populate the customer object
        customer.setName(name);
        customer.setEmail(email);
        customers.add(customer); // Save customer to in-memory list
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // Endpoint to get a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(c -> new ResponseEntity<>(CustomerMapper.INSTANCE.customerToCustomerDTO(c), HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to update a customer by ID
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        if (!customerRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        customer.setId(id);
        Customer updatedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(CustomerMapper.INSTANCE.customerToCustomerDTO(updatedCustomer), HttpStatus.OK);
    }

    // Endpoint to delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint to search customers by name and email
    @GetMapping("/search")
    public List<Customer> searchCustomers(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String email) {
        return customers.stream()
                .filter(customer -> (name == null || customer.getName().contains(name)) &&
                                    (email == null || customer.getEmail().contains(email)))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                                 .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
                                 .toList();
    }
}
