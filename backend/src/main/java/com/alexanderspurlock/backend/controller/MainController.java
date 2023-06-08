package com.alexanderspurlock.backend.controller;

import java.util.List;

import com.alexanderspurlock.backend.model.Counter;
import com.alexanderspurlock.backend.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alexanderspurlock.backend.model.Employee;
import com.alexanderspurlock.backend.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class MainController {
    private final EmployeeService employeeService;
    private final CounterService counterService;

    @Autowired
    public MainController(EmployeeService employeeService, CounterService counterService) {
        this.employeeService = employeeService;
        this.counterService = counterService;
    }

    @GetMapping(value = "/employees", produces = "application/json")
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAll();
    }

    @GetMapping("/counters")
    public List<Counter> getAllCounters() {
        return this.counterService.getAll();
    }

    @PostMapping("/counter")
    public ResponseEntity<String> addCounter(@RequestBody Counter counter) {
        System.out.println(counter);
        this.counterService.add(counter);
        return ResponseEntity.ok("Counter added.");
    }

}
