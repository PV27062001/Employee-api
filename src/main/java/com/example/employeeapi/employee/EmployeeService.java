package com.example.employeeapi.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public String deleteEmployeeById(Long id){
         employeeRepository.deleteById(id);
         return "deleted";
    }


}
