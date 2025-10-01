package com.hiberus.employees.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String role;
    private double salary;

    private LocalDate hireDate;
    private LocalDate endDate;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}