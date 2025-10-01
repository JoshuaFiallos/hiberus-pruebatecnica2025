package com.hiberus.employees.controller;

import com.hiberus.employees.model.Department;
import com.hiberus.employees.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping("/create")
    public Department create(@RequestBody Department department) {
        return service.createDepartment(department);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDepartment(id);
    }
}
