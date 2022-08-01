package com.example.lesson2_13;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("passport") Integer passport,
                                @RequestParam("department") Integer department,
                                @RequestParam("salary") Double salary) {
        return employeeService.addEmployee(firstName, lastName, passport, department, salary );
    }

    @RequestMapping("/remove")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("passport") Integer passport,
                                   @RequestParam("department") Integer department,
                                   @RequestParam("salary") Double salary) {
        return employeeService.deleteEmployee(firstName, lastName, passport, department, salary);
    }

    @RequestMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("passport") Integer passport,
                                 @RequestParam("department") Integer department,
                                 @RequestParam("salary") Double salary) {
        return employeeService.findEmployee(firstName, lastName, passport, department, salary);
    }

    @RequestMapping(path = "/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}

