package com.example.employeeapi.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEMployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getby/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getall")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @DeleteMapping("/deleteby/{id}")
    public String deleteEmployeeByid(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
