package com.hiberus.employees.repository;

import com.hiberus.employees.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}