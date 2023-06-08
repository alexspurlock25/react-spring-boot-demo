package com.alexanderspurlock.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.alexanderspurlock.backend.model.Employee;
import com.alexanderspurlock.backend.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        this.employeeRepository.findAll().forEach(employee ->
            employees.add(employee)
        );
        
        return employees;
    }

    public void add(Employee employee) {
        this.employeeRepository.save(employee);
    }
}
