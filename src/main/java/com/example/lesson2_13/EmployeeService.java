package com.example.lesson2_13;

import com.example.lesson2_13.Exceptions.ChecksAlphaException;
import com.example.lesson2_13.Exceptions.EmployeeAlreadyAddedException;
import com.example.lesson2_13.Exceptions.EmployeeNotFoundException;
import com.example.lesson2_13.Exceptions.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final int LIMIT = 10;
    private final Map<Integer, Employee> emp1 = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, Integer passport,
                                Integer department, Double salary) {
        checkAlpha(firstName, lastName);
        Employee emp = new Employee(firstName, lastName, passport, department, salary);
        if (emp1.containsKey(passport)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (emp1.size() < LIMIT) {
            emp1.put(emp.getPassport(), emp);
            return emp;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee deleteEmployee(String firstName, String lastName, Integer passport,
                                   Integer department, Double salary) {
        checkAlpha(firstName, lastName);
        Employee emp = new Employee(firstName, lastName, passport, department, salary);
        if (!emp1.containsKey(emp.getPassport())) {
            throw new EmployeeNotFoundException();
        }
        emp1.remove(emp);
        return emp;
    }

    public Employee findEmployee(String firstName, String lastName, Integer passport,
                                 Integer department, Double salary) {
        checkAlpha(firstName, lastName);
        Employee emp = new Employee(firstName, lastName,passport, department, salary);
        if (emp1 == null){
            throw new EmployeeNotFoundException();
        }
        return emp;
    }
    public List<Employee> getAll (){
        return new ArrayList<>(emp1.values());
    }

    private void checkAlpha (String firstName, String lastName){
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))){
            throw new ChecksAlphaException();
        }
    }
}
