package com.hiberus.employees.service;

import com.hiberus.employees.dto.EmployeeDTO;
import com.hiberus.employees.model.Department;
import com.hiberus.employees.model.Employee;
import com.hiberus.employees.repository.DepartmentRepository;
import com.hiberus.employees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public Employee create(Long departmentId, EmployeeDTO dto) {
        Department department = departmentRepo.findById(departmentId).orElseThrow();
        Employee emp = Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .role(dto.getRole())
                .salary(dto.getSalary())
                .hireDate(dto.getHireDate())
                .endDate(dto.getEndDate())
                .active(true)
                .department(department)
                .build();
        return employeeRepo.save(emp);
    }

    public void delete(Long id) {
        Employee emp = employeeRepo.findById(id).orElseThrow();
        emp.setActive(false);
        employeeRepo.save(emp);
    }

    public Employee highestSalary() {
        return employeeRepo.findByActiveTrue().stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee lowerAge() {
        return employeeRepo.findByActiveTrue().stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public long countLastMonth() {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        return employeeRepo.findByHireDateAfter(lastMonth).stream()
                .filter(Employee::isActive)
                .count();
    }
}