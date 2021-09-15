package model.entity;

import view.View;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;

public class Department {
    private final String name;
    private ArrayList<Employee> employeesInDepartment;
    private final SalaryDistribution salaryDistribution;
    private BigDecimal departmentSalaryFund;
    public static BigDecimal BIRTHDAY_BONUS = BigDecimal.valueOf(3000);

    public Department(String name, SalaryDistribution salaryDistribution){
        this.name = name;
        this.salaryDistribution = salaryDistribution;
        this.employeesInDepartment = new ArrayList<>();
    }

    public SalaryDistribution getSalaryDistribution() {
        return salaryDistribution;
    }

    public void addEmployee(Employee employee){
        employeesInDepartment.add(employee);
    }

    public void setDepartmentSalaryFund(BigDecimal fund){
        departmentSalaryFund = fund;
    }

    public BigDecimal getDepartmentSalaryFund() {
        return departmentSalaryFund;
    }

    public String getName() {
        return name;
    }

    public boolean isEnoughMoneyInFund(int month) {
        if (employeesInDepartment.isEmpty()) {
            return true;
        } else {
            BigDecimal totalSalary = totalSalaryPlusBirthdayBonus(month);
            return totalSalary.compareTo(departmentSalaryFund) < 0;
        }
    }

    public ArrayList<Employee> getEmployeesInDepartment() {
        return employeesInDepartment;
    }

    public BigDecimal calculateTotalSalary() {
        BigDecimal totalSalary = BigDecimal.valueOf(0);
        for (Employee employee : employeesInDepartment) {
            totalSalary = totalSalary.add(employee.getSalary());
        }
        return totalSalary;
    }

    public int totalBirthdayCount(int month) {
        int birthdayCount = 0;
        for (Employee employee : employeesInDepartment) {
            if (employee.getBirthDate().getMonth().getValue() == month) {
                birthdayCount++;
            }
        }
        return birthdayCount;
    }

    public BigDecimal totalSalaryPlusBirthdayBonus(int month) {
        BigDecimal totalSalary = calculateTotalSalary();
        totalSalary = totalSalary.add(BIRTHDAY_BONUS.multiply(BigDecimal.valueOf(totalBirthdayCount(month))));
        return totalSalary;
    }

    public BigDecimal equalMonthBonus(int month) {
        BigDecimal bonus = departmentSalaryFund.subtract(totalSalaryPlusBirthdayBonus(month));
            bonus = bonus.divide(BigDecimal.valueOf(employeesInDepartment.size()),2, RoundingMode.HALF_UP);
        return bonus;
    }
}
