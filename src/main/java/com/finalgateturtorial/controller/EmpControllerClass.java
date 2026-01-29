package com.finalgateturtorial.controller;

import com.finalgateturtorial.entity.Employee;
import com.finalgateturtorial.service.EmpServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import java.util.List;


@RestController
@RequestMapping("/api/v1/emp")
public class EmpControllerClass {
    @Autowired
    private EmpServiceClass empServiceClass;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee saved = empServiceClass.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(saved);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> employees = empServiceClass.getEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
  

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getUser(@PathVariable Long id) {
        Optional<Employee> employee = empServiceClass.getUserById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}