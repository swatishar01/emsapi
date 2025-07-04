package com.example.emsapi.service;

import com.example.emsapi.entity.Employee;
import com.example.emsapi.db.EmployeeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDB repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public Employee get(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Employee> searchEmployees(String keyword) {
        List<Employee> allEmployees = repository.findAll();
        if (keyword != null && !keyword.isEmpty()) {
            return allEmployees.stream()
                    .filter(employee ->
                            (employee.getFirstName() != null && employee.getFirstName().toLowerCase().contains(keyword.toLowerCase())) ||
                                    (employee.getLastName() != null && employee.getLastName().toLowerCase().contains(keyword.toLowerCase())) ||
                                    (employee.getEmail() != null && employee.getEmail().toLowerCase().contains(keyword.toLowerCase())))
                    .toList();
        }
        return allEmployees;
    }
    // getEmployeeById
    public Employee getEmployeeById(Long id) {
        return repository.findById(Math.toIntExact(id)).orElse(null);
    }
}