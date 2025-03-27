package com.satishlabs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.satishlabs.dto.EmployeeInput;
import com.satishlabs.model.Employee;
import com.satishlabs.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(EmployeeInput input) {
        Employee employee = new Employee();
        employee.setName(input.getName());
        employee.setEmail(input.getEmail());
        employee.setDepartment(input.getDepartment());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Long id, EmployeeInput updateEmp) {
        return employeeRepository.findById(id)
                .map(existingEmp -> {
                    if (updateEmp.getName() != null) existingEmp.setName(updateEmp.getName());
                    if (updateEmp.getEmail() != null) existingEmp.setEmail(updateEmp.getEmail());
                    if (updateEmp.getDepartment() != null) existingEmp.setDepartment(updateEmp.getDepartment());
                    return employeeRepository.save(existingEmp);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
