package com.finalgateturtorial.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;
    private String empDeparment;
    private Double empSalary;

    // No-args constructor (required by JPA)
    public Employee() {}

    // All-args constructor
    public Employee(Long empId, String empName, String empDeparment, Double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empDeparment = empDeparment;
        this.empSalary = empSalary;
    }

    // Getters and Setters
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDeparment() {
        return empDeparment;
    }

    public void setEmpDeparment(String empDeparment) {
        this.empDeparment = empDeparment;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}