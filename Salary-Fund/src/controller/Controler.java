package controller;

import model.Model;
import model.entity.Department;
import model.entity.Employee;
import model.entity.SalaryDistribution;
import view.View;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Controler {
    private View view;
    private Model model;

    public Controler(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        Department firstDepartment = new Department("Games", SalaryDistribution.EQUAL);
        firstDepartment.addEmployee(new Employee("Oleg",LocalDate.of(1984,9,18), BigDecimal.valueOf(20000)));
        firstDepartment.setDepartmentSalaryFund(BigDecimal.valueOf(10000));;
        System.out.println(firstDepartment.isEnoughMoneyInFund());
    }

}
