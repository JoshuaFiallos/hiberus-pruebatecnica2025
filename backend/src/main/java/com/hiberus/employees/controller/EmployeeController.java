package com.hiberus.employees.controller;

import com.hiberus.employees.dto.EmployeeDTO;
import com.hiberus.employees.model.Employee;
import com.hiberus.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/create/{departmentId}")
    public Employee create(@PathVariable Long departmentId, @RequestBody EmployeeDTO dto) {
        return service.create(departmentId, dto);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/highestSalary")
    public Employee highestSalary() {
        return service.highestSalary();
    }

    @GetMapping("/lowerAge")
    public Employee lowerAge() {
        return service.lowerAge();
    }

    @GetMapping("/countLastMonth")
    public long countLastMonth() {
        return service.countLastMonth();
    }
}