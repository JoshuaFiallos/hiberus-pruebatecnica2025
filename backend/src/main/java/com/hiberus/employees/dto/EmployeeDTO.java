package com.hiberus.employees.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String role;
    private double salary;
    private LocalDate hireDate;
    private LocalDate endDate;
}