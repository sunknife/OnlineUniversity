package controller;

import model.entity.Department;
import model.entity.Employee;
import view.View;

import java.math.BigDecimal;
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
                BigDecimal bonus = department.monthBonus(month);
                view.printMessage("Department [" + department.getName() + "]  Month: " + LocalDate.of(2021, month, 31).getMonth());
                for (Employee employee: department.getEmployeesInDepartment()) {
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
