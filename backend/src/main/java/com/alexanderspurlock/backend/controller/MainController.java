package com.alexanderspurlock.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexanderspurlock.backend.model.Employee;
import com.alexanderspurlock.backend.repository.EmployeeRepository;
import com.alexanderspurlock.backend.service.EmployeeService;

@RestController("/")
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    public MainController() {
        this.employeeService = new EmployeeService(employeeRepository);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.getAll();
    }
}
