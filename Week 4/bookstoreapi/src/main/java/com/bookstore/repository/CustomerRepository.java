package com.bookstore.repository;


import com.bookstore.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    // Find a customer by their email
    Optional<Customer> findByEmail(String email);

    // Find customers by their last name
    List<Customer> findByLastName(String lastName);
}
