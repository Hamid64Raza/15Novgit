package com.finalgateturtorial.service;

import com.finalgateturtorial.entity.Employee;
import com.finalgateturtorial.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceClass {
    @Autowired
    private  EmpRepository empRepository;

    public Employee addEmployee(Employee employee) {
        return empRepository.save(employee);
    }

    {

    }
}
