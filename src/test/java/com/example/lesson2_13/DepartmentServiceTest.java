package com.example.lesson2_13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.example.lesson2_13.Constants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1),
            new Employee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT1, SALARY2),
            new Employee(FIRSTNAME3, LASTNAME3, PASSPORT3, DEPARTMENT2, SALARY3),
            new Employee(FIRSTNAME4, LASTNAME4, PASSPORT4, DEPARTMENT2, SALARY4)));


    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void shouldReturnGetAllDepart() {
        Mockito.when(employeeService.getAll()).thenReturn(employees);
        List <Employee> expected = departmentService.allInDepartment(1);
        Assertions.assertEquals(expected, departmentService.allInDepartment(1));
    }

    @Test
    public void shouldReturnDepartMaxSalary (){
        Mockito.when(employeeService.getAll()).thenReturn(employees);
        Employee expected = departmentService.departMaxSalary(1);
        Assertions.assertEquals(expected, departmentService.departMaxSalary(1));
    }

    @Test
    public void shouldReturnDepartMinSalary (){
        Mockito.when(employeeService.getAll()).thenReturn(employees);
        Employee expected = departmentService.departMinSalary(2);
        Assertions.assertEquals(expected, departmentService.departMinSalary(2));
    }

}
