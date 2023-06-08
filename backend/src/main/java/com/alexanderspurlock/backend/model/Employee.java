package com.alexanderspurlock.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Employee {
    @Id @GeneratedValue Long id;
    private String name;

    public Employee(String name) {
        this.name = name;
    }
}
