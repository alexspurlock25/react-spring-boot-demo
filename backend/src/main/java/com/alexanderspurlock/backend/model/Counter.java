package com.alexanderspurlock.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString
@EqualsAndHashCode
public class Counter {
    @Id @GeneratedValue Long id;
    private int counter;

    public Counter() {
        this.counter = 0;
    }
}
