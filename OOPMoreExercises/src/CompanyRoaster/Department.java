package CompanyRoaster;

import java.util.List;

public class Department {
    String name;
    List<Employee> employees;

    Department(String name, List<Employee> employees){
        this.name = name;
        this.employees = employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public String toString() {
        return String.format("%s",getName());
    }

    public double getAverageSalary(List<Employee> employees){
        double sum = 0;
        for (Employee e : employees) {
            sum += e.getSalary();
        }
        return sum / employees.size();
    }
}
