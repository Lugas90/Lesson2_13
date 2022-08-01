package com.example.lesson2_13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.lesson2_13.Constants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private final EmployeeService employeeService;

    public DepartmentServiceTest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private final EmployeeService out = new EmployeeService();

    private final Employee emp1 = out.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
    private final Employee emp2 = out.addEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT1, SALARY2);
    private final Employee emp3 = out.addEmployee(FIRSTNAME3, LASTNAME3, PASSPORT3, DEPARTMENT2, SALARY3);
    private final Employee emp4 = out.addEmployee(FIRSTNAME4, LASTNAME4, PASSPORT4, DEPARTMENT2, SALARY4);

    @Mock
    private DepartmentService departmentMock;

    @Test
    public void shouldReturnDepartMaxSalary (){


    }

}
