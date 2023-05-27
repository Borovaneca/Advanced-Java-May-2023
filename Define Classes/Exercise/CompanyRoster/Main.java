package Advance.DefineClasses.Exercise.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rotation = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();


        for (int i = 1; i <= rotation; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String employeeDepartment = inputData[3];
            Employee current = new Employee();
            if (inputData.length == 6) {
                String email = inputData[4];
                int age = Integer.parseInt(inputData[5]);
                current = new Employee(name, salary, position, employeeDepartment, email, age);

            } else if (inputData.length == 5) {
                if (inputData[4].contains("@")) {
                    String email = inputData[4];
                    current = new Employee(name, salary, position, employeeDepartment, email);
                } else {
                    int age = Integer.parseInt(inputData[4]);
                    current = new Employee(name, salary, position, employeeDepartment, age);
                }
            } else {
                current = new Employee(name, salary, position, employeeDepartment);
            }

            employeeList.add(current);

            if (!departmentList.stream().anyMatch(department -> department.getName().equals(employeeDepartment))) {
                Department department = new Department(employeeDepartment);
                departmentList.add(department);
            }

            Department currentDepartment = departmentList.stream()
                    .filter(dep -> dep.getName().equals(employeeDepartment))
                    .findFirst()
                    .get();

            currentDepartment.addEmployee(current);
        }


        Department highestDepartment = departmentList.stream()
                .max((first, second) -> Double.compare(first.calcAverageSalary(), second.calcAverageSalary()))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestDepartment.getName());

        highestDepartment.getList()
                .stream()
                .sorted((first, second) -> Double.compare(second.getSalary(), first.getSalary()))
                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}
