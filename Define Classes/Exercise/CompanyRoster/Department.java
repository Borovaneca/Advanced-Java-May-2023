package Advance.DefineClasses.Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> list;

    public Department(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        list.add(employee);
    }
    public String getName() {
        return name;
    }

    public double calcAverageSalary() {
        return this.list.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }
}
