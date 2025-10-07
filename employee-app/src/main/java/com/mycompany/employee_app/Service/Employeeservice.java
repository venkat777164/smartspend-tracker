package com.example.employees.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public Employee save(Employee e) { return repo.save(e); }
    public List<Employee> findAll() { return repo.findAll(); }
    public Optional<Employee> findByEmployeeId(String employeeId) { return repo.findByEmployeeId(employeeId); }
}
