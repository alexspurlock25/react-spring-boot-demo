package com.alexanderspurlock.backend.service;

import com.alexanderspurlock.backend.model.Counter;
import com.alexanderspurlock.backend.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CounterService {
    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public List<Counter> getAll() {
        List<Counter> counters = new ArrayList<>();
        this.counterRepository.findAll().forEach(counter -> counters.add(counter));
        return counters;
    }

    public Counter getCounterById(Long id) throws Exception {
        Optional<Counter> optional = this.counterRepository.findById(id);

        if (!optional.isPresent())
            throw new Exception("Counter doesn't exist.");
        return optional.get();
    }

    public void add(Counter counter) {
        counter.setCounter(0); // always start the counter with a 0
        this.counterRepository.save(counter);
    }

    public void increment(Long counterId) throws Exception {
        Optional<Counter> optional = this.counterRepository.findById(counterId);

        if (optional.isPresent()) {
            Counter counter = optional.get();

            int currentCounter = counter.getCounter();
            counter.setCounter(currentCounter + 1);

            this.counterRepository.save(counter);
        } else {
            throw new Exception("Counter with given id is not present.");
        }
    }
}
