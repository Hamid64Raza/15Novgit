package com.finalgateturtorial.controllertest;

import com.finalgateturtorial.controller.EmpControllerClass;
import com.finalgateturtorial.entity.Employee;
import com.finalgateturtorial.service.EmpServiceClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmpControllerClass.class)
class EmpControllerClassTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpServiceClass empServiceClass;

    @Test
    void testCreateEmployee() throws Exception {
        Employee emp = new Employee(1L, "Hamid", "IT", 50000.0);

        // Use argument matcher instead of exact object
        when(empServiceClass.addEmployee(





                any(Employee.class))).thenReturn(emp);

        mockMvc.perform(post("/api/v1/emp/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"empId\":1,\"empName\":\"Hamid\",\"empDeparment\":\"IT\",\"empSalary\":50000}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // ensure JSON response
                .andExpect(jsonPath("$.empName").value("Hamid"))
                .andExpect(jsonPath("$.empDeparment").value("IT"));
    }

    @Test    void testGetEmployee() throws Exception {
        Employee emp1 = new Employee(1L, "Hamid", "IT", 50000.0);
        Employee emp2 = new Employee(2L, "Ali", "HR", 40000.0);

        when(empServiceClass.getEmployee()).thenReturn(Arrays.asList(emp1, emp2));

        mockMvc.perform(get("/api/v1/emp/read"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].empName").value("Hamid"))
                .andExpect(jsonPath("$[1].empName").value("Ali"));
    }

    @Test
    void testGetUser_Found() throws Exception {
        Employee emp = new Employee(1L, "Hamid", "IT", 50000.0);

        w++hen(empServiceClass.getUserById(1L)).thenReturn(Optional.of(emp));

        mockMvc.perform(get("/api/v1/emp/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empName").value("Hamid"));
    }

    @Test
    void testGetUser_NotFound() throws Exception {
        when(empServiceClass.getUserById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/emp/99"))
                .andExpect(status().isNotFound());
    }
}