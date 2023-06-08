package com.alexanderspurlock.backend.repository;

import com.alexanderspurlock.backend.model.Counter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Long> {
}
