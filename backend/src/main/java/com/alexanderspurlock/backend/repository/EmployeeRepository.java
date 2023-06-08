package com.alexanderspurlock.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexanderspurlock.backend.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    // auto generated crud operations
}
