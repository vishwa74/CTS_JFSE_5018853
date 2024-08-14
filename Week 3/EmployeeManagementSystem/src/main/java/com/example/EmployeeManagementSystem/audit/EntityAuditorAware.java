package com.example.EmployeeManagementSystem.audit;
// Exercise: 7

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin"); // Or use Spring Security to get the current user
    }
}
