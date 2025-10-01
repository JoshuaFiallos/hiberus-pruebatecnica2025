package com.hiberus.employees.repository;

import com.hiberus.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByActiveTrue();
    List<Employee> findByHireDateAfter(LocalDate date);
}