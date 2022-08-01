package com.example.lesson2_13;

import com.example.lesson2_13.Exceptions.EmployeeAlreadyAddedException;
import com.example.lesson2_13.Exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.List;

import static com.example.lesson2_13.Constants.*;

public class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    @Test
    public void shouldReturnAddEmployee() {
        Employee expected = new Employee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        out.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Employee actual = out.findEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmployeeAlreadyAddedException() {
        out.addEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2));
    }

    @Test
    public void shouldReturnDeleteEmployee() {
        Employee expected = null;
        out.addEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        out.deleteEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        Employee actual = out.findEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
       Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmployeeNotFoundException (){
        out.addEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        out.deleteEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.deleteEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2));
    }

    @Test
    public void shouldReturnFindEmployee() {
        Employee expected = new Employee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        out.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Employee actual = out.findEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnGetAllEmployee() {
        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2));
        expected.add(new Employee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1));
        out.addEmployee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
        out.addEmployee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT2, SALARY2);
        List<Employee> actual = new ArrayList<>(out.getAll());
        Assertions.assertEquals(expected, actual);
    }
}
