package com.hiberus.employees.service;

import com.hiberus.employees.model.Department;
import com.hiberus.employees.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public Department createDepartment(Department department) {
        department.setActive(true);
        return repository.save(department);
    }

    public void deleteDepartment(Long id) {
        Department dep = repository.findById(id).orElseThrow();
        dep.setActive(false);
        repository.save(dep);
    }
}