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

    public void addEmployee(Employee employee){
        employeesInDepartment.add(employee);
    }

    public void setDepartmentSalaryFund(BigDecimal fund){
        departmentSalaryFund = fund;
    }

    public boolean isEnoughMoneyInFund() {
        if (employeesInDepartment.isEmpty()) {
            return true;
        } else {
            BigDecimal totalSalary = BigDecimal.valueOf(0);
            for (Employee employee: employeesInDepartment) {
                totalSalary = totalSalary.add(employee.getSalary());
                System.out.println("Employee salary = " + employee.getSalary());
                System.out.println(totalSalary);
            }
            return totalSalary.compareTo(departmentSalaryFund) < 0;
        }
    }

}
