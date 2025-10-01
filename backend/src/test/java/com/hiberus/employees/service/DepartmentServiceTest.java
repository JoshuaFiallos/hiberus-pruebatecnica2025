package com.hiberus.employees.service;

import com.hiberus.employees.model.Department;
import com.hiberus.employees.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private DepartmentRepository repository;
    private DepartmentService service;

    @BeforeEach
    void setup() {
        repository = mock(DepartmentRepository.class);
        service = new DepartmentService(repository);
    }

    @Test
    void testCreateDepartment() {
        Department dep = new Department(null, "RRHH", true);
        Department saved = new Department(1L, "RRHH", true);

        when(repository.save(dep)).thenReturn(saved);

        Department result = service.createDepartment(dep);

        assertEquals("RRHH", result.getName());
    }

    @Test
    void testDeleteDepartment() {
        Department dep = new Department(1L, "Ventas", true);
        when(repository.findById(1L)).thenReturn(Optional.of(dep));

        service.deleteDepartment(1L);

        assertFalse(dep.isActive());
        verify(repository).save(dep);
    }
}