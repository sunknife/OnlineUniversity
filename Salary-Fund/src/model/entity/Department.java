package model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> employeesInDepartment;
    private SalaryDistribution salaryDistribution;
    private BigDecimal departmentSalaryFund;

    public Department(String name, SalaryDistribution salaryDistribution){
        this.name = name;
        this.salaryDistribution = salaryDistribution;
        this.employeesInDepartment = new ArrayList<>();
    }

}
