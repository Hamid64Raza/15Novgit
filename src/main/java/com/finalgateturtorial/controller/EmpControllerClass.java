package com.finalgateturtorial.controller;

import com.finalgateturtorial.entity.Employee;
import com.finalgateturtorial.service.EmpServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emp")
public class EmpControllerClass {
    @Autowired
    private EmpServiceClass empServiceClass;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        System.out.println(employee.getEmpId());
        System.out.println(employee.getEmpName());
        System.out.println(employee.getEmpDeparment());
        System.out.println(employee.getEmpSalary());

        Employee employee1=empServiceClass.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/read")
    public ResponseEntity<Object> getEmployee() {
           List<Employee> employee=empServiceClass.getEmployee();
        return new ResponseEntity<Object>(employee, HttpStatusCode.valueOf(200));
    }

}
