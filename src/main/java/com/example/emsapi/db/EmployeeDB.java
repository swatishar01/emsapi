package com.example.emsapi.db;

import com.example.emsapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDB extends JpaRepository<Employee,Integer> {
    boolean existsAllByEmail(String email);
}
