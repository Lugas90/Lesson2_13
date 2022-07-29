package com.example.lesson2_13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController (DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee departMaxSalary (@RequestParam("department") Integer department) {
        return departmentService.departMaxSalary(department);
    }

    @GetMapping (path = "/min-salary")
    public Employee departMinSalary (@RequestParam("department") Integer department){
        return departmentService.departMinSalary(department);
    }
    @GetMapping (value = "/all", params = "department")
    public List<Employee> allDepartment (@RequestParam("department") Integer department){
        return departmentService.allInDepartment(department);
    }
    @GetMapping (value = "/all")
    public Map<Integer, List <Employee>> allEmployeeFromDepartment (){
        return departmentService.allEmployeeFromDepartment();
    }


}
