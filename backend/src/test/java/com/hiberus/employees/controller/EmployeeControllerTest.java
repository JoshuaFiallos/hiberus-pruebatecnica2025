package com.hiberus.employees.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiberus.employees.dto.EmployeeDTO;
import com.hiberus.employees.model.Employee;
import com.hiberus.employees.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateEmployee() throws Exception {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName("Luis");
        dto.setLastName("Gomez");
        dto.setAge(30);
        dto.setRole("QA");
        dto.setSalary(2000);
        dto.setHireDate(LocalDate.now());

        Employee response = Employee.builder().id(1L).firstName("Luis").lastName("Gomez").age(30).role("QA").salary(2000).hireDate(LocalDate.now()).active(true).build();

        when(service.create(Mockito.eq(1L), Mockito.any(EmployeeDTO.class))).thenReturn(response);

        mockMvc.perform(post("/employee/create/1")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Luis"));
    }
}