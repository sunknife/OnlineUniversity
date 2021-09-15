package controller;

import model.entity.Department;
import model.entity.Employee;
import model.entity.SalaryDistribution;
import view.View;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;

public class Payroll {
    private ArrayList<Department> departments;
    private View view;

    public Payroll(View view) {
        departments = new ArrayList<>();
        this.view = view;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void generateMonthSalary(int month) {
        for (Department department : departments) {
            if (!department.isEnoughMoneyInFund(month)) {
                view.printMessage(View.NOT_ENOUGH_MONEY + department.getName());
            } else {
                BigDecimal bonus = BigDecimal.valueOf(0);
                if (department.getSalaryDistribution()== SalaryDistribution.EQUAL) {
                    bonus = department.equalMonthBonus(month);
                }
                view.printMessage("Department [" + department.getName() + "]  Month: " + LocalDate.of(2021, month, 28).getMonth());
                for (Employee employee: department.getEmployeesInDepartment()) {
                    if (department.getSalaryDistribution() == SalaryDistribution.PROPORTIONAL) {
                        bonus = employee.getSalary().divide(department.calculateTotalSalary(),2, RoundingMode.HALF_UP);
                        bonus = bonus.multiply(department.getDepartmentSalaryFund().subtract(department.totalSalaryPlusBirthdayBonus(month)));
                    }
                    if (employee.getBirthDate().getMonth().getValue() == month)  {
                        view.printMessage("Employee " + employee.getFullName() + " salary = " + employee.getSalary().add(bonus).add(Department.BIRTHDAY_BONUS));
                    } else {
                        view.printMessage("Employee " + employee.getFullName() + " salary = " + employee.getSalary().add(bonus));
                    }
                }
            }
        }
    }

}
