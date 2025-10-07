package com.example.employees.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
    @Id
    private String id;            // Mongo _id
    @Indexed(unique = true)
    private String employeeId;   // business id from form (E001 etc)
    private String name;
    private String email;
    private String location;

    public Employee() {}
    public Employee(String employeeId, String name, String email, String location) {
        this.employeeId = employeeId; this.name = name; this.email = email; this.location = location;
    }
    // getters + setters
    // ... generate or write standard getters/setters
}
