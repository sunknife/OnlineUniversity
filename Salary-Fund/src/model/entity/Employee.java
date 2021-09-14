package model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String fullName;
    private LocalDate birthDate;
    private BigDecimal salary;

    public Employee(String fullName, LocalDate birthDate, BigDecimal salary){
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return fullName;
    }
}
