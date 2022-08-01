package com.example.lesson2_13;

import com.example.lesson2_13.Exceptions.EmployeeAlreadyAddedException;
import com.example.lesson2_13.Exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.example.lesson2_13.Constants.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService = new EmployeeService();

    private final Map<Integer, Employee> dataTest = new HashMap<>();

    @Test
    public void shouldReturnAddEmployee() {
        Map <Integer, Employee> emp = new HashMap<>();
        Employee expected = new Employee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Employee result = employeeService.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnEmployeeAlreadyAddedException (){
        Employee result = employeeService.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1));
    }

    @Test
    public void shouldReturnDeleteEmployee (){
        Employee expected = employeeService.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        dataTest.put(expected.getPassport(), expected);
        employeeService.deleteEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Employee actual = dataTest.get(expected.getPassport());
        Assertions.assertNull(actual);
    }

    @Test
    public void shouldReturnFindEmployee (){
        Employee expected = new Employee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        Employee result = employeeService.findEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        Assertions.assertEquals(expected, result);
    }

 //   @Test
 //   public void shouldReturnEmployeeNotFoundExceptionInFindEmployee (){
 //       Employee expected = null;
 //       Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2));
  //  }
}
