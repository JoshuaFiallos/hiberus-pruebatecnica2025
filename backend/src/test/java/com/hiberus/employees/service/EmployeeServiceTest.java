package com.hiberus.employees.service;

import com.hiberus.employees.dto.EmployeeDTO;
import com.hiberus.employees.model.Department;
import com.hiberus.employees.model.Employee;
import com.hiberus.employees.repository.DepartmentRepository;
import com.hiberus.employees.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private EmployeeRepository employeeRepo;
    private DepartmentRepository departmentRepo;
    private EmployeeService service;

    @BeforeEach
    void setup() {
        employeeRepo = mock(EmployeeRepository.class);
        departmentRepo = mock(DepartmentRepository.class);
        service = new EmployeeService(employeeRepo, departmentRepo);
    }

    @Test
    void testCreateEmployee() {
        Department dep = Department.builder().id(1L).name("IT").active(true).build();
        when(departmentRepo.findById(1L)).thenReturn(Optional.of(dep));

        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName("Juan");
        dto.setLastName("Perez");
        dto.setAge(28);
        dto.setRole("Developer");
        dto.setSalary(3000);
        dto.setHireDate(LocalDate.now());

        Employee created = Employee.builder().id(1L).firstName("Juan").lastName("Perez").age(28).role("Developer").salary(3000).hireDate(LocalDate.now()).active(true).department(dep).build();
        when(employeeRepo.save(any(Employee.class))).thenReturn(created);

        Employee result = service.create(1L, dto);

        assertEquals("Juan", result.getFirstName());
        assertEquals("Perez", result.getLastName());
    }

    @Test
    void testDeleteEmployee() {
        Employee emp = Employee.builder().id(1L).firstName("Ana").active(true).build();
        when(employeeRepo.findById(1L)).thenReturn(Optional.of(emp));

        service.delete(1L);

        assertFalse(emp.isActive());
        verify(employeeRepo).save(emp);
    }
}