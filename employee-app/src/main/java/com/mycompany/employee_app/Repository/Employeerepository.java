package com.example.employees.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.employees.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findByEmployeeId(String employeeId);
}
