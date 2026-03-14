package com.example.employeeservice.dto;

import com.example.employeeservice.entity.Employee;

public class ResponseDTO {
    private Employee employee;
    private DepartmentDTO department;

    public ResponseDTO() {}
    public ResponseDTO(Employee employee, DepartmentDTO department) {
        this.employee = employee;
        this.department = department;
    }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public DepartmentDTO getDepartment() { return department; }
    public void setDepartment(DepartmentDTO department) { this.department = department; }
}
