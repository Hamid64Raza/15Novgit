package com.finalgateturtorial.controller;

import com.finalgateturtorial.entity.Employee;
import com.finalgateturtorial.service.EmpServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getUser(@PathVariable Long id){
       Optional<Employee> employee=empServiceClass.getUserById(id);
       if(employee.isPresent()){
           return new ResponseEntity<Employee>(employee.get(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

    }

}
