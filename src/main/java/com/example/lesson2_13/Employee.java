package com.example.lesson2_13;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer passport;
    private Integer department;
    private Double salary;

    public Employee (String firstName, String lastName, Integer passport,
                     Integer department, Double salary){
        this.firstName = StringUtils.capitalize(firstName);
        this.lastName = StringUtils.capitalize(lastName);
        this.passport = passport;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName (){
        return this.firstName;
    }
    public String getLastName (){
        return this.lastName;
    }
    public Integer getPassport() {
        return this.passport;
    }
    public Integer getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName)
                && Objects.equals(passport, employee.passport) && Objects.equals(department, employee.department)
                && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passport, department, salary);
    }

    public String toString(){
        return "сотрудник: " + firstName + " " + lastName + " " + passport + " " + department + " " + salary;
    }
}
