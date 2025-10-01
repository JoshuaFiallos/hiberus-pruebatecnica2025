package com.hiberus.employees.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiberus.employees.model.Department;
import com.hiberus.employees.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateDepartment() throws Exception {
        Department dep = new Department(1L, "Finanzas", true);
        when(service.createDepartment(dep)).thenReturn(dep);

        mockMvc.perform(post("/department/create")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dep)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Finanzas"));
    }
}