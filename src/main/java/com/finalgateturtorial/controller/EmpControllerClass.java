package com.finalgateturtorial.controller;

import com.finalgateturtorial.entity.Employee;
import com.finalgateturtorial.service.EmpServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        System.out.println(employee.getEmpId());
        System.out.println(employee.getEmpName());
        System.out.println(employee.getEmpDeparment());
        System.out.println(employee.getEmpSalary());

        Employee savedEmployee = empServiceClass.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); // 201 is better for creation
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