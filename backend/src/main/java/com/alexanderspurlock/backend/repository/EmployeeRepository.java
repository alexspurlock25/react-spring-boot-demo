package com.alexanderspurlock.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexanderspurlock.backend.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    // auto generated crud operations
}
