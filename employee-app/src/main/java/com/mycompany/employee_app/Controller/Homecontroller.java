package com.example.employees.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;

@Controller
public class HomeController {
    private final EmployeeService service;
    public HomeController(EmployeeService service){ this.service = service; }

    // Landing page with form
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("employee", new Employee());
        return "index";             // src/main/resources/templates/index.html
    }

    // Handle form POST (RESTful URL: POST /employees)
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute Employee employee){
        service.save(employee);
        return "redirect:/displayAll";
    }

    // Render page that shows all employees (path /displayAll)
    @GetMapping("/displayAll")
    public String displayAll(Model model){
        model.addAttribute("employees", service.findAll());
        return "displayAll";       // src/main/resources/templates/displayAll.html
    }

    // Render a page for a single employee by employeeId (path /display/{userId})
    @GetMapping("/display/{employeeId}")
    public String displayByEmployeeId(@PathVariable String employeeId, Model model){
        var opt = service.findByEmployeeId(employeeId);
        model.addAttribute("employee", opt.orElse(null));
        return "display";          // src/main/resources/templates/display.html
    }
}
