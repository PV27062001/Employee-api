package com.example.employeeapi.employee;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DbInitializer {

    private final EmployeeRepository employeeRepository;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Autowired
    public DbInitializer(EmployeeRepository employeeRepository, ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        if (employeeRepository.count() == 0) {
            try {
                // Load data from employees.json file
                Resource resource = resourceLoader.getResource("classpath:mockData.json");
                List<Employee> employees = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Employee>>() {});

                // Save employees to the database
                employeeRepository.saveAll(employees);
            } catch (IOException e) {
                // Handle exception if the JSON file cannot be read or employees cannot be saved
                e.printStackTrace();
            }
        }
    }
}
