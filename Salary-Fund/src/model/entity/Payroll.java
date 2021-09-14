package model.entity;

import java.util.ArrayList;

public class Payroll {
    private ArrayList<Department> departments;

    public Payroll() {
        departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }


}
