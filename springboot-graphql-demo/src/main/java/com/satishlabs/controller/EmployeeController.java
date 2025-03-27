package com.satishlabs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.satishlabs.dto.EmployeeInput;
import com.satishlabs.model.Employee;
import com.satishlabs.service.EmployeeService;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @QueryMapping
    public Optional<Employee> getEmployeeById(@Argument Long id) {
        return employeeService.getEmployeeById(id);
    }

    @MutationMapping
    public Employee createEmployee(@Argument EmployeeInput input) {
        return employeeService.createEmployee(input);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Long id, @Argument EmployeeInput input) {
        return employeeService.updateEmployee(id, input);
    }

    @MutationMapping
    public Boolean deleteEmployee(@Argument Long id) {
        return employeeService.deleteEmployee(id);
    }
}
