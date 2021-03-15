package CompanyRoaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Department> departments = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];

            switch (employeeData.length){
                case 4:
                    if (containsDepartment(departments, department) != null){
                        Department newDepartment = containsDepartment(departments, department);
                        assert newDepartment != null;
                        List<Employee> employees = newDepartment.getEmployees();
                        Employee employee = new Employee(name, salary, position, newDepartment);
                        employees.add(employee);
                        newDepartment.setEmployees(employees);
                        departments.set(getIndex(departments, department), newDepartment);
                    }else {
                        List<Employee> employees = new ArrayList<>();
                        Department newDepartment = new Department(department, employees);
                        Employee employee = new Employee(name, salary, position, newDepartment);
                        employees.add(employee);
                        newDepartment.setEmployees(employees);
                        departments.add(newDepartment);
                    }
                    break;
                case 5:
                    if (employeeData[4].contains("@")){
                        if (containsDepartment(departments, department) != null){
                            Department departmentNew = containsDepartment(departments, department);
                            assert departmentNew != null;
                            List<Employee> employees = departmentNew.getEmployees();
                            Employee employee = new Employee(name, salary, position, departmentNew);
                            employee.setEmail(employeeData[4]);
                            employees.add(employee);
                            departmentNew.setEmployees(employees);
                            departments.set(getIndex(departments, department), departmentNew);
                        }else {
                            List<Employee> employees = new ArrayList<>();
                            Department newDepartment = new Department(department, employees);
                            Employee employee = new Employee(name, salary, position, newDepartment);
                            employee.setEmail(employeeData[4]);
                            employees.add(employee);
                            newDepartment.setEmployees(employees);
                            departments.add(newDepartment);
                        }
                    }else {
                        if (containsDepartment(departments, department) != null){
                            Department departmentNew = containsDepartment(departments, department);
                            assert departmentNew != null;
                            List<Employee> employees = departmentNew.getEmployees();
                            Employee employee = new Employee(name, salary, position, departmentNew);
                            employee.setAge(Integer.parseInt(employeeData[4]));
                            employees.add(employee);
                            departmentNew.setEmployees(employees);
                            departments.set(getIndex(departments, department), departmentNew);
                        }else {
                            List<Employee> employees = new ArrayList<>();
                            Department newDepartment = new Department(department, employees);
                            Employee employee = new Employee(name, salary, position, newDepartment);
                            employee.setAge(Integer.parseInt(employeeData[4]));
                            employees.add(employee);
                            newDepartment.setEmployees(employees);
                            departments.add(newDepartment);
                        }
                    }
                    break;
                case 6:
                    if (containsDepartment(departments, department) != null){
                        Department newDepartment = containsDepartment(departments, department);
                        assert newDepartment != null;
                        List<Employee> employees = newDepartment.getEmployees();
                        Employee employee = new Employee(name, salary, position, newDepartment);
                        employee.setEmail(employeeData[4]);
                        employee.setAge(Integer.parseInt(employeeData[5]));
                        employees.add(employee);

                    }else {
                        List<Employee> employees = new ArrayList<>();
                        Department newDepartment = new Department(department, employees);
                        Employee employee = new Employee(name, salary, position, newDepartment);
                        employee.setEmail(employeeData[4]);
                        employee.setAge(Integer.parseInt(employeeData[5]));
                        employees.add(employee);
                        newDepartment.setEmployees(employees);
                        departments.add(newDepartment);
                    }
            }
        }

        departments.stream()
                .sorted((d1, d2) -> Double.compare(d2.getAverageSalary(d2.getEmployees()),d1.getAverageSalary(d1.getEmployees())))
                .limit(1)
                .forEach(department -> {
                    System.out.println("Highest Average Salary:");
                    System.out.println(department.toString());
                    for (Employee e : department.getEmployees()) {
                        System.out.println(e.toString());
                    }
                });
    }

    private static int getIndex(List<Department> departments, String department) {
        for ( Department d : departments) {
            if (d.getName().equals(department)){
                return departments.indexOf(d);
            }
        }
        return -1;
    }

    private static Department containsDepartment(List<Department> departments, String departmentName) {
        for (Department dep : departments) {
            if (dep.getName().equals(departmentName)){
                return dep;
            }
        }
        return null;
    }
}
