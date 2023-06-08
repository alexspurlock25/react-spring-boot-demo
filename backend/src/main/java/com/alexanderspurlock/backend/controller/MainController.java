package com.alexanderspurlock.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexanderspurlock.backend.model.Employee;
import com.alexanderspurlock.backend.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class MainController {
    private final EmployeeService employeeService;

    @Autowired
    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees", produces = "application/json")
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAll();
    }
}
