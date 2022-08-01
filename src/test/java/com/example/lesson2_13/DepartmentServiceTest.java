package com.example.lesson2_13;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static com.example.lesson2_13.Constants.*;

public class DepartmentServiceTest {

    private final Employee emp1 = new Employee(FIRSTNAME1, LASTNAME1, PASSPORT1, DEPARTMENT1, SALARY1);
    private final Employee emp2 = new Employee(FIRSTNAME2, LASTNAME2, PASSPORT2, DEPARTMENT1, SALARY2);
    private final Employee emp3 = new Employee(FIRSTNAME3, LASTNAME3, PASSPORT3, DEPARTMENT2, SALARY3);
    private final Employee emp4 = new Employee(FIRSTNAME4, LASTNAME4, PASSPORT4, DEPARTMENT2, SALARY4);

    @Mock
    private DepartmentService departmentMock;

    @Test
    public void shouldReturnDepartMaxSalary (){


    }

}
